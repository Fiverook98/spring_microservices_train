package com.util.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name= "Country")
public class Country {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name="countryName")
    String countryName;

    @Column(name="population")
    long population;

    public Country(){
        super();
    }

    public Country(String countryName, long population){
        super();
        this.countryName = countryName;
        this.population = population;
    }

    public UUID getId() {
        return id;
    }

    public String getCountryName(){
        return countryName;
    }

    public long getPopulation(){
        return population;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
