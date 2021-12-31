package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;

import java.util.List;

public interface AirlineService {

    public List<Airline> findAll();

    public Airline findById(int theId);

    public void save(Airline theAirline);

    public void deleteById(int theId);


}
