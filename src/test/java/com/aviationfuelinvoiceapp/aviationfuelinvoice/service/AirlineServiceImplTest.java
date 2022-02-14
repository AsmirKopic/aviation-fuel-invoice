package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AirlineServiceImplTest {

    @Mock
    private AirlineRepository airlineRepository;

    private AirlineServiceImpl airlineTestService;

    @BeforeEach
    void setUp() {
        airlineTestService = new AirlineServiceImpl(airlineRepository);
    }

    @AfterEach
    void tearDown() {
        airlineRepository.deleteAll();
    }

    @Test
    void willFindAll() {
        // when
        airlineTestService.findAll();

        //then
        verify(airlineRepository).findAll();
    }

    @Test
    void willFindById() {

        Airline airline = given();
        airlineRepository.save(airline);

        // when
        airlineRepository.findById(airline.getAirlineId());

        // capture airline value
        ArgumentCaptor<Integer> airlineArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // check is AirlineRepository invoked findById() method with captured airline ID value
        verify(airlineRepository).findById(airlineArgumentCaptor.capture());
        Integer capturedAirlineId = airlineArgumentCaptor.getValue();

        assertThat(airline.getAirlineId()).isEqualTo(capturedAirlineId);
    }

    @Test
    void canSaveAirline() {

        Airline airline = given();

        // when
        airlineRepository.save(airline);

        // capture airline value
        ArgumentCaptor<Airline> airlineArgumentCaptor = ArgumentCaptor.forClass(Airline.class);

        // check is AirlineRepository invoked save() method with captured airline value
        verify(airlineRepository).save(airlineArgumentCaptor.capture());
        Airline capturedAirline = airlineArgumentCaptor.getValue();

        assertThat(airline).isEqualTo(capturedAirline);
    }

    @Test
    void canDeleteById() {

        Airline airline = given();
        airlineRepository.save(airline);

        // when
        airlineRepository.deleteById(airline.getAirlineId());

        // capture airline value
        ArgumentCaptor<Integer> airlineArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // check is AirlineRepository invoked delete() method with captured airline value
        verify(airlineRepository).deleteById(airlineArgumentCaptor.capture());
        Integer capturedAirlineId = airlineArgumentCaptor.getValue();

        assertThat(airline.getAirlineId()).isEqualTo(capturedAirlineId);
    }

    @Test
    void canSearchByName() {

        Airline airline = given();
        airlineRepository.save(airline);

        // when
        airlineRepository.findByNameContainsAllIgnoreCase(airline.getName());

        // capture airline value
        ArgumentCaptor<String> airlineArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // check is AirlineRepository invoked findByName() method with captured airline value
        verify(airlineRepository).findByNameContainsAllIgnoreCase(airlineArgumentCaptor.capture());
        String capturedAirlineName = airlineArgumentCaptor.getValue();

        assertThat(airline.getName()).isEqualTo(capturedAirlineName);
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