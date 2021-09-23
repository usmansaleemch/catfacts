package com.elabor8.catfacts;

import com.elabor8.catfacts.exporter.Exporter;
import com.elabor8.catfacts.exporter.FileExporter;
import com.elabor8.catfacts.model.Fact;
import com.elabor8.catfacts.model.FactsSummary;
import com.elabor8.catfacts.parser.FileParser;
import com.elabor8.catfacts.parser.PSVFileParser;
import com.elabor8.catfacts.processor.FactListProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainApplication {

    private FileParser fileParser;
    private Exporter exporter;

    /**
     * Creates MainApplication with parser and exporter interfaces
     * @param fileParser Implementation of Cats Facts file parser
     * @param exporter Implementation of exporter
     */
    public MainApplication(final FileParser fileParser, final Exporter exporter){
        this.fileParser = fileParser;
        this.exporter = exporter;
    }

    /**
     * Analyse method carries out following operation in order
     *  1. Reads input file i.e. csv
     *  2. Parse and converts file data to domain model object
     *  3. Delegates model to processor for sorting according to requirements
     *  4. Exports to output file i.e. csv
     * @param fileName Input file containing list of facts per user
     * @throws IOException
     */
    public void analyze(final String fileName) throws IOException {

        final List<String> lines = Files.readAllLines(Paths.get(fileName));
        final List<Fact> factList = fileParser.parseLinesFrom(lines);

        final FactListProcessor factListProcessor = new FactListProcessor(factList);
        List<FactsSummary> groupedFactsList = factListProcessor.process();

        System.out.println(exporter.export(groupedFactsList));
    }

    public static void main(String[] args) throws IOException {
        // Inject implementations via constructors
        final FileParser namesFileParser = new PSVFileParser();
        final Exporter exporter = new FileExporter();

        MainApplication mainApplication = new MainApplication(namesFileParser, exporter);

        if (args.length == 0 ) {
            throw new IllegalArgumentException("Path for file is required.");
        }

        mainApplication.analyze(args[0]);
    }
}
