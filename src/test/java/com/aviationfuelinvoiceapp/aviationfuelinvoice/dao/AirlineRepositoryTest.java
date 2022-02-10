package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AirlineRepositoryTest {

    @Autowired
    AirlineRepository testRepo;

    @AfterEach
    void tearDown() {
        testRepo.deleteAll();
    }

    @Test
    void itShouldFindByNameContains() {

        Airline airline = given();

        testRepo.save(airline);

        List<Airline> containingList = testRepo.findByNameContainsAllIgnoreCase(airline.getName());
        boolean expected = containingList.contains(airline);

        assertThat(expected).isTrue();
    }

    @Test
    void itShouldReturnEmptyList() {

        Airline airline = given();

        testRepo.save(airline);

        List<Airline> containingList = testRepo.findByNameContainsAllIgnoreCase("Fail test name");
        boolean expected = containingList.isEmpty();

        assertThat(expected).isTrue();
    }

    private Airline given(){

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);

        return airline;
    }
}