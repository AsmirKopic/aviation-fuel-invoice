package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AirlineServiceImplTest {

    @Mock
    private AirlineRepository airlineTestRepo;
    private AirlineServiceImpl airlineTestService;

    @BeforeEach
    void setUp() {
        airlineTestService = new AirlineServiceImpl(airlineTestRepo);
    }

    @AfterEach
    void tearDown() {
        airlineTestRepo.deleteAll();
    }

    @Test
    void willFindAll() {
        // when
        airlineTestService.findAll();
        verify(airlineTestRepo).findAll();
    }

    @Test
    @Disabled
    void findById() {

        Airline airline = new Airline();
        airline.setAirlineId(1);
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);
        airlineTestService.save(airline);

        airlineTestService.findById(airline.getAirlineId());
        verify(airlineTestRepo).findById(airline.getAirlineId());
    }

    @Test
    void canSaveAirline() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);

        airlineTestService.save(airline);

        // capture airline value
        ArgumentCaptor<Airline> airlineArgumentCaptor = ArgumentCaptor.forClass(Airline.class);

        // check is AirlineRepository invoked save() method with captured airline value
        verify(airlineTestRepo).save(airlineArgumentCaptor.capture());

        Airline capturedAirline = airlineArgumentCaptor.getValue();

        assertThat(airline).isEqualTo(capturedAirline);
    }

    @Test
    @Disabled
    void deleteById() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);

        airlineTestService.deleteById(airline.getAirlineId());


        // check is AirlineRepository invoked delete() method with captured airline value
        verify(airlineTestRepo).deleteById(airline.getAirlineId());

        List<Airline> airlines = airlineTestRepo.findAll();

        assertThat(airline).isNotIn(airlines);
    }

    @Test
    @Disabled
    void searchByName() {
    }
}