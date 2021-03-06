package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> findAll();

    public Invoice findById(int theId);

    public void save(Invoice theInvoice);

    public void deleteById(int theId);

    public List<Invoice> searchById(int theId);

    public List<Invoice> findByAirlineId(int theId);

    public double sumTotalLit();

    public double sumTotalKg();

    public double sumTotalValue();

    public double calculatePrice(Invoice theInvoice, Airline theAirline);

    public double calculateDifferential(Invoice theInvoice, Airline theAirline);
}



