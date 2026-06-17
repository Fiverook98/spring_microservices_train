package com.training.controller;


import com.training.Repo.CountryRepository;
import com.util.Entity.Country;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    private CountryRepository repository;

    @RequestMapping(value = "/cerca/{country}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Optional<Country>> researchByName(@PathVariable("country") String countryName){
        Optional<Country> res = repository.findByName(countryName);
        return new ResponseEntity<Optional<Country>>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @RequestMapping(value="/addCountry", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Country> addNewCountry(@RequestBody Country country){
        Country res = repository.save(country);
        return new ResponseEntity<Country>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<Country>> getAllCountries(){
        Iterable<Country> res = repository.findAll();
        return new ResponseEntity<Iterable<Country>>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> deleteCountry(@PathVariable("id") UUID id){
        String res = "Country with id: " + id + " deleted";
        repository.DelRowCountryName(id);
        return new ResponseEntity<String>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @PutMapping(value = "/modifyAll", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> modifyCountry(@RequestBody Country country) {

        String res = "Country with id: " + country.getId() + " modified";
        repository.UpdRowCountry(country.getCountryName(), country.getPopulation(), country.getId());
        return new ResponseEntity<String>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @PutMapping(value = "/modifyPop", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> modifyCountryPop(@RequestBody Country country) {
        String res = "Country with id: " + country.getId() + " modified with new population: " + country.getPopulation();
        repository.UpdCountryPop(country.getPopulation(), country.getId());
        return new ResponseEntity<String>(res, HttpHeaders.EMPTY, HttpStatus.OK);
    }


}
