package com.elabor8.catfacts.parser;

import com.elabor8.catfacts.model.Fact;

import java.util.List;

/**
 * Represents a file parser interface.
 * Provides a contract to be implemented for various formats i.e json, xml etc
 * @author Usman Chodhary
 * @version 1.0
 */
public interface FileParser {

    Fact parseFromLine(final String line);
    List<Fact> parseLinesFrom(final List<String> lines);

}
