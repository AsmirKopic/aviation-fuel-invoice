package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * FROM invoices WHERE airline_id = ?1", nativeQuery = true)
    List<Invoice> findByAirlineId(int theId);




    //fix query
    @Query(value = "SELECT SUM(total_days) FROM MyEntity", nativeQuery = true)
    Double sumLitByAirlineId(int theId);



}
