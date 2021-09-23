package com.elabor8.catfacts.exporter;

import com.elabor8.catfacts.model.Fact;
import com.elabor8.catfacts.model.FactsSummary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/** File Exporter is specific implementation of exporter.
 * @author Usman Chodhary
 * @version 1.0
 */
public class FileExporter implements Exporter {

    public static final String RESOURCES = "src/main/resources/";
    public static final String OUTPUT_FILE = "facts-output.csv";
    public static final String MESSAGE = "Finished: created " + OUTPUT_FILE;

    /**
     * Converts List of facts object to List of string and export to output file
     * @param factsResults List of facts results per user
     * @return constant string
     */
    @Override
    public String export(List<FactsSummary> factsResults) {

        List<String> sortedFactResultsAsString = factsResults.stream()
                .map(fact -> fact.getFullName()+","+fact.getTotalUpVotes())
                .collect(Collectors.toList());

        try {
            writeToFile(sortedFactResultsAsString);
        } catch (IOException e) {
            // Log to console via log4j
            System.out.println(e.getMessage());
        }
        return MESSAGE;
    }

    /**
     * Utility method for writing list of strings to file
     * @param stringList List of String
     * @throws IOException
     */
    private void writeToFile(List<String> stringList) throws IOException {
        Path path = Paths.get(RESOURCES+OUTPUT_FILE);
        Files.write(path, stringList);
    }

}
