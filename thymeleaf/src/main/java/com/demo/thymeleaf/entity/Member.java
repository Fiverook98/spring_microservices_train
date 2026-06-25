package com.demo.thymeleaf.entity;


public class Member {
    private String firstName;
    private String lastName;
    private String country;
    private String language;

    public Member(){}

    public Member(String inputName, String inputSurname, String inputCountry, String inputLang) {
        firstName = inputName;
        lastName = inputSurname;
        country = inputCountry;
        language = inputLang;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setLanguage(String language) {
        this.language = language;
    }
}
