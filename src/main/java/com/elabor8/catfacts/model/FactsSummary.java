package com.elabor8.catfacts.model;

import java.util.Objects;

public class FactsSummary {

    private String fullName;
    private int totalUpVotes;

    public FactsSummary(String fullName, int totalUpVotes) {
        this.fullName = fullName;
        this.totalUpVotes = totalUpVotes;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTotalUpVotes() {
        return totalUpVotes;
    }

    public void setTotalUpVotes(int totalUpVotes) {
        this.totalUpVotes = totalUpVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactsSummary that = (FactsSummary) o;
        return totalUpVotes == that.totalUpVotes && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, totalUpVotes);
    }
}
