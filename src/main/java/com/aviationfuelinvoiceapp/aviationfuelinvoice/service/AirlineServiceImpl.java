package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService{

    AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    @Transactional
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    @Transactional
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
    @Transactional
    public void save(Airline theAirline) {

        airlineRepository.save(theAirline);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

        airlineRepository.deleteById(theId);
    }

    @Override
    public List<Airline> searchByName(String name) {

        List<Airline> result = null;

        if (name != null && (name.trim().length() > 0)) {
            result = airlineRepository.findByNameContainsAllIgnoreCase(name);
        } else {
            result = findAll();
        }

        return result;
    }


}
