package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @AfterEach
    void tearDown() {
        invoiceRepository.deleteAll();
        airlineRepository.deleteAll();
    }

    @Test
    void itShouldQueryById() {

        Invoice invoice = given();
        invoiceRepository.save(invoice);

        List<Invoice> queryList = invoiceRepository.queryById(invoice.getId());
        boolean expected = queryList.contains(invoice);

        assertThat(expected).isTrue();
    }

    @Test
    void canSumTotalLit() {

        Invoice invoiceOne = given();
        Invoice invoiceTwo = given();
        invoiceRepository.save(invoiceOne);
        invoiceRepository.save(invoiceTwo);

        double expected = invoiceRepository.sumTotalLit();
        assertThat(expected).isEqualTo(invoiceOne.getUpliftLit() + invoiceTwo.getUpliftLit());
    }

    @Test
    void canSumTotalKg() {

        Invoice invoiceOne = given();
        Invoice invoiceTwo = given();
        invoiceRepository.save(invoiceOne);
        invoiceRepository.save(invoiceTwo);

        double expected = invoiceRepository.sumTotalKg();
        assertThat(expected).isEqualTo(invoiceOne.getUpliftKg() + invoiceTwo.getUpliftKg());
    }

    @Test
    void canSumTotalValue() {

        Invoice invoiceOne = given();
        Invoice invoiceTwo = given();
        invoiceRepository.save(invoiceOne);
        invoiceRepository.save(invoiceTwo);

        double expected = invoiceRepository.sumTotalValue();
        assertThat(expected).isEqualTo(invoiceOne.getTotalPrice() + invoiceTwo.getTotalPrice());
    }

    private Invoice given(){

        Airline airline = givenAirline();
        airlineRepository.save(airline);

        Invoice invoice = new Invoice();

        invoice.setAirline(airline);
        invoice.setDate("02.02.2022");
        invoice.setUpliftKg(1000.00);
        invoice.setUpliftLit(1100.00);
        invoice.setAircraftRegistration("testReg");
        invoice.setAircraftType("testType");
        invoice.setTicketNumber("testTicket");
        invoice.setFlightNumber("testFlight");
        invoice.setTotalPrice(500.00);

        return invoice;
    }

    private Airline givenAirline(){

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);

        return airline;
    }



}