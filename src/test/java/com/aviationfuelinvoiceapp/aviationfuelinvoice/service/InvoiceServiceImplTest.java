package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.AirlineRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.InvoiceRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    @Mock
    InvoiceRepository invoiceRepository;

    @Mock
    AirlineRepository airlineRepository;

    InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceServiceImpl(invoiceRepository);
    }

    @AfterEach
    void tearDown() {
        invoiceRepository.deleteAll();
        airlineRepository.deleteAll();
    }

    @Test
    void willFindAll() {

        // when
        invoiceService.findAll();

        // then
        verify(invoiceRepository).findAll();
    }

    @Test
    void willFindById() {

        Invoice invoice = given();
        invoiceRepository.save(invoice);

        // when
        invoiceRepository.findById(invoice.getId());

        // capture invoiceId value
        ArgumentCaptor<Integer> invoiceArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // check is InvoiceRepository invoked findById() method with captured invoice ID value
        verify(invoiceRepository).findById(invoiceArgumentCaptor.capture());
        Integer capturedValue = invoiceArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(invoice.getId());
    }

    @Test
    void canSaveInvoice() {

        Invoice invoice = given();

        // when
        invoiceRepository.save(invoice);

        // capture value
        ArgumentCaptor<Invoice> invoiceArgumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        // check is invoiceRepository invoked save() method with captured Invoice value
        verify(invoiceRepository).save(invoiceArgumentCaptor.capture());
        Invoice capturedInvoice = invoiceArgumentCaptor.getValue();

        assertThat(capturedInvoice).isEqualTo(invoice);
    }

    @Test
    void canDeleteById() {

        Invoice invoice = given();
        invoiceRepository.save(invoice);

        // when
        invoiceRepository.deleteById(invoice.getId());

        // capture value
        ArgumentCaptor<Integer> invoiceArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // check is invoiceRepository invoked save() method with captured Invoice value
        verify(invoiceRepository).deleteById(invoiceArgumentCaptor.capture());
        Integer capturedValue = invoiceArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(invoice.getId());
    }

    @Test
    void findByAirlineId() {

        Invoice invoice = given();
        invoiceRepository.save(invoice);

        // when
        invoiceRepository.findByAirlineId(invoice.getAirline().getAirlineId());

        // capture invoiceId value
        ArgumentCaptor<Integer> invoiceArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // check is InvoiceRepository invoked findByAirlineId() method with captured value
        verify(invoiceRepository).findByAirlineId(invoiceArgumentCaptor.capture());
        Integer capturedValue = invoiceArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(invoice.getAirline().getAirlineId());
    }

    private Invoice given(){

        Airline airline = givenAirline();
        airlineRepository.save(airline);

        Invoice invoice = new Invoice();

        invoice.setId(10);
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
        airline.setAirlineId(5);
        airline.setName("Test Airline");
        airline.setAddress("Airline test address");
        airline.setDifferential(700.00);
        airline.setPaymentTerms(15);

        return airline;
    }
}