package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    // search by name
    public List<Airline> findByNameContainsAllIgnoreCase(String name);

    public List<Airline> findByNameContaining(String name);
}
