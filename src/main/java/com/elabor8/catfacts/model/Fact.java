package com.elabor8.catfacts.model;

public class Fact {

    private String firstName;
    private String lastName;
    private int upVotes;

    public Fact(String firstName, String lastName, int upVotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.upVotes = upVotes;
    }

    public String getFullName() {
        return firstName +" "+ lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }
}
