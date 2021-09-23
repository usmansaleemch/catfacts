package com.elabor8.catfacts;

import com.elabor8.catfacts.model.Fact;
import com.elabor8.catfacts.model.FactsSummary;
import com.elabor8.catfacts.processor.FactListProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class FactsListProcessorTest {

    @Test
    public void shouldGroupAndSortUnorderedList() throws Exception {

        final List<Fact> nameList = Arrays.asList(
                new Fact("USMAN","CHODHARY",1),
                new Fact("MIKE","JORDAN",2),
                new Fact("MIKE","JORDAN",2));

        final List<FactsSummary> expectedNameList = Arrays.asList(
                new FactsSummary("MIKE JORDAN",4),
                new FactsSummary("USMAN CHODHARY", 1)
        );

        final FactListProcessor namesListProcessor = new FactListProcessor(nameList);
        List<FactsSummary> result = namesListProcessor.process();

        Assert.assertThat(result, is(expectedNameList));

    }


}
