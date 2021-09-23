package com.elabor8.catfacts;

import com.elabor8.catfacts.model.Fact;
import com.elabor8.catfacts.parser.FileParser;
import com.elabor8.catfacts.parser.PSVFileParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class FileParserTest {

    private final FileParser fileParser = new PSVFileParser();


    @Test
    public void shouldParseOneCorrectLine() throws Exception {

        final String line = "599f89639a11040c4a163440|Here is a video of some cats in zero gravity. youtu.be/O9XtK6R1QAk|cat|5a9ac18c7478810ea6c06381|Alex|Wohlbruck|5|null";
        final Fact result = fileParser.parseFromLine(line);
        final Fact expectedName = new Fact("Alex","Wohlbruck", 5);

        Assert.assertEquals(expectedName.getFirstName(),result.getFirstName());
        Assert.assertEquals(expectedName.getLastName(), result.getLastName());
    }

    @Test
    public void shouldParseLinesToNames() throws Exception {

        final List<String> lines = Arrays.asList(
        "header1|header2|header3|header4|header5|header6|header7|header8",
        "5b4911940508220014ccfe94|Some fact 1|cat|5a9ac18c7478810ea6c06381|Alex|Wohlbruck|7|null",
        "58e008ad0aac31001185ed0c|Some fact 2|cat|58e007480aac31001185ecef|Kasimir|Schulz|11|null"
        );
        final List<Fact> result = fileParser.parseLinesFrom(lines);

        final List<Fact> expectedNameList = Arrays.asList(
                new Fact("Alex","Wohlbruck",7),
                new Fact("Kasimir","Schulz",11));

        Assert.assertEquals(expectedNameList.size(),result.size());
        Assert.assertEquals(expectedNameList.get(0).getFirstName(),result.get(0).getFirstName());
        Assert.assertEquals(expectedNameList.get(1).getFirstName(),result.get(1).getFirstName());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenParseIncorrectLine() throws Exception {

        final String line = "5b4911940508220014ccfe94|Some";
        final Fact result = fileParser.parseFromLine(line);
    }

}
