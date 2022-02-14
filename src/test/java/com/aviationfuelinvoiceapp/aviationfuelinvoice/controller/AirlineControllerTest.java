package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AirlineControllerTest {

    @Autowired
    private AirlineRepository airlineRepository;
    private AirlineServiceImpl airlineTestService;

    @BeforeEach
    void setUp() {
        airlineTestService = new AirlineServiceImpl(airlineRepository);
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void listAirlines() throws Exception {
        List<Airline> records = givenList();

        Mockito.when(airlineTestService.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/airline/list")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(3)))
                        .andExpect(jsonPath("$[2].name", is("Airline Three address")));
    }

    @Test
    void showFormForAdd() {
    }

    @Test
    void save() {
    }

    @Test
    void showFormForUpdate() {
    }

    @Test
    void delete() {
    }

    @Test
    void search() {
    }

    @Test
    void showInfo() {
    }

    private Airline given(){

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(300.00);
        airline.setPaymentTerms(1);

        return airline;
    }

    private List<Airline> givenList(){

        Airline airline1 = new Airline();
        airline1.setName("Test Airline One");
        airline1.setAddress("Airline One test address");
        airline1.setDifferential(500.00);
        airline1.setPaymentTerms(5);

        Airline airline2 = new Airline();
        airline2.setName("Test Airline Two");
        airline2.setAddress("AAirline Two address");
        airline2.setDifferential(600.00);
        airline2.setPaymentTerms(10);

        Airline airline3 = new Airline();
        airline3.setName("Test Airline Three");
        airline3.setAddress("Airline Three address");
        airline3.setDifferential(700.00);
        airline3.setPaymentTerms(15);

        List<Airline> givenList = new ArrayList<>(Arrays.asList(airline1, airline2, airline3));

        return givenList;
    }
}