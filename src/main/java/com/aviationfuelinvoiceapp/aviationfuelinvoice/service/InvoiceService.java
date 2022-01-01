package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> findAll();

    public Invoice findByInd(int theId);

    public void save(Invoice theInvoice);

    public void deleteById(int theId);
}
