package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> findAll();

    public Invoice findById(int theId);

    public void save(Invoice theInvoice);

    public void deleteById(int theId);

    public List<Invoice> findByAirlineId(int theId);

}



