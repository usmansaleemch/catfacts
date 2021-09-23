package com.elabor8.catfacts.processor;

import com.elabor8.catfacts.model.Fact;
import com.elabor8.catfacts.model.FactsSummary;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.*;

/**
 * Fact List Processor involves data operations on unordered list of facts created after parsing
 * @author Usman Chodhary
 * @version 1.0
 */
public class FactListProcessor {

    private final List<Fact> facts;

    /**
     * Create Fact List processor with unordered list of facts
     * @param facts list of facts object
     */
    public FactListProcessor(List<Fact> facts) {
        this.facts = facts;
    }

    /**
     * Group Facts in a map with First Name and Last as key and sum of up votes as value
     * @return Sorted List of names
     */
    public List<FactsSummary> process() {
        // Group
        Map<String, Integer> groupFactsByUser = facts.stream()
                .collect(groupingBy(Fact::getFullName, summingInt(Fact::getUpVotes)));

        // Sort desc by upVotes
        Map<String, Integer> sortResult = new LinkedHashMap<>();
        groupFactsByUser.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortResult.put(x.getKey(), x.getValue()));

        // Convert map to Fact-Summary object
        List<FactsSummary> factSummary = sortResult.entrySet()
                .stream()
                .map(entry -> new FactsSummary(entry.getKey(),entry.getValue()))
                .collect(Collectors.toList());

        return factSummary;
    }
}
