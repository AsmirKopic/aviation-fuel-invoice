package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    public List<Airline> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
