package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService{

    AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline findById(int theId) {

        Optional<Airline> result = airlineRepository.findById(theId);

        Airline theAirline = null;

        if (result.isPresent()) {
            theAirline = result.get();
        } else {
            throw new RuntimeException("Did not find airline with id" + theId);
        }

        return theAirline;
    }

    @Override
    public void save(Airline theAirline) {

        airlineRepository.save(theAirline);
    }

    @Override
    public void deleteById(int theId) {

        airlineRepository.deleteById(theId);
    }

    @Override
    public List<Airline> searchByName(String name) {

        List<Airline> results = null;

        if (results != null && ((name.trim().length() > 0))){

            results = airlineRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
        } else {
            results = findAll();
        }

        return results;
    }

}
