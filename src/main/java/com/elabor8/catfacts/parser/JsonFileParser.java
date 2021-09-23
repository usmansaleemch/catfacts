package com.elabor8.catfacts.parser;

import com.elabor8.catfacts.model.Fact;

import java.util.List;

public class JsonFileParser implements FileParser {
    @Override
    public Fact parseFromLine(String line) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Fact> parseLinesFrom(List<String> lines) {
        throw new UnsupportedOperationException();
    }
}
