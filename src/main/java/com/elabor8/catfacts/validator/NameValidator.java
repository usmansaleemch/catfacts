package com.elabor8.catfacts.validator;

public class NameValidator {

    private String firstName;
    private String lastName;

    public NameValidator(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Notification validate() {

        final Notification notification = new Notification();

        if (firstName.isEmpty()){
            notification.addError("First name is missing");
        }

        if (lastName.isEmpty()){
            notification.addError("Last name is missing");
        }
        // More constraint/validations goes here

        return notification;
    }

}
