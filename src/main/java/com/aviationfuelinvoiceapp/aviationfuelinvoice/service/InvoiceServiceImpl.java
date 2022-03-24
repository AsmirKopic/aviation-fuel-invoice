package com.aviationfuelinvoiceapp.aviationfuelinvoice.service;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.dao.InvoiceRepository;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {

       return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int theId) {

        Optional<Invoice> result = invoiceRepository.findById(theId);
        Invoice theInvoice = null;

        if (result.isPresent()) {
            theInvoice = result.get();
        } else {
            throw new RuntimeException("Did not find invoice with id " + theId );
        }
        return theInvoice;
    }

    @Override
    public void save(Invoice theInvoice) {
        invoiceRepository.save(theInvoice);
    }

    @Override
    public void deleteById(int theId) {
        invoiceRepository.deleteById(theId);
    }

    @Override
    public List<Invoice> searchById(int theId) {

        List<Invoice> result = null;

        if (theId > 0) {
            result = invoiceRepository.queryById(theId);
        } else {
            result = findAll();
        }

        return result;
    }

    @Override
    public List<Invoice> findByAirlineId(int theId) {
        return invoiceRepository.findByAirlineId(theId);
    }

    @Override
    public double sumTotalLit() {
        return invoiceRepository.sumTotalLit();
    }

    @Override
    public double sumTotalKg() {
        return invoiceRepository.sumTotalKg();
    }

    @Override
    public double sumTotalValue() {
        return invoiceRepository.sumTotalValue();
    }

    @Override
    public double calculatePrice(Invoice theInvoice, Airline theAirline) {

        double totalPrice = (theAirline.getDifferential() / 1000) * theInvoice.getUpliftKg();

        return totalPrice;
    }


}
