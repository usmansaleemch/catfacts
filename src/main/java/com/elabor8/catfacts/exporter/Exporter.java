package com.elabor8.catfacts.exporter;

import com.elabor8.catfacts.model.FactsSummary;

import java.util.List;

/** Exporter interface provides a export contract
 * @author Usman Chodhary
 * @version 1.0
 */
public interface Exporter {
    /**
     * Abstract contract method
     * @param factsResults List of facts
     * @return String representation per line
     */
    String export(List<FactsSummary> factsResults);

}
