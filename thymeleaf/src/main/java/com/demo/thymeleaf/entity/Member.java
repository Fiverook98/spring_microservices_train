package com.demo.thymeleaf.entity;


import com.demo.thymeleaf.validation.PostalCode;
import jakarta.validation.constraints.*;

public class Member {

    @NotNull(message = "is required")
    @Size(min=3, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=3, message = "is required")
    private String lastName;

    @PostalCode
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;

    private String country;
    private String language;
    private String OS;

    @NotNull(message = "is required")
    @Min(value=0, message="must be grater than or equal zero")
    @Max(value=45, message="are you serious??")
    private Integer seniority;

    public Member(){}

    public Member(String inputName, String inputSurname, String inputCountry, String inputLang, String inputOS) {
        firstName = inputName;
        lastName = inputSurname;
        country = inputCountry;
        language = inputLang;
        OS = inputOS;
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

    public String getOS() { return OS; }

    public String getLanguage() { return language; }

    public Integer getSeniority() { return seniority; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public void setSeniority(Integer seniority) { this.seniority = seniority; }

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

    public void setOS(String OS) { this.OS = OS; }
}
