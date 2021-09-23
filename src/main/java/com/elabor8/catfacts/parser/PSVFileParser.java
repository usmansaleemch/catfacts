package com.elabor8.catfacts.parser;

import com.elabor8.catfacts.model.Fact;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Pipe Seperated File parser implementation.
 * @author Usman Chodhary
 * @version 1.0
 */
public class PSVFileParser implements FileParser {
    /**
     * Split line by delimiter and populate domain model
     * @param line Represents a record in file
     * @return Fact -domain object constructed after splitting line
     */
    public Fact parseFromLine(final String line) {

        final String[] factRecord = line.split("\\|");

        final String firstName = factRecord[4];
        final String lastName = factRecord[5];
        final int upVotes = Integer.parseInt(factRecord[6]);

        return new Fact(firstName, lastName, upVotes);
    }

    public List<Fact> parseLinesFrom(final List<String> lines) {
        return lines.stream().skip(1).map(this::parseFromLine).collect(Collectors.toList());
    }

}
