package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    /*
     * Query by airline id
     */

    @Query(value = "SELECT * FROM invoices WHERE airline_id = ?1", nativeQuery = true)
    List<Invoice> findByAirlineId(int theId);

    @Query(value = "SELECT SUM(upliftLit) FROM invoices WHERE airline_id = ?1", nativeQuery = true)
    double sumLitByAirlineId(int theId);

    @Query(value = "SELECT SUM(upliftKg) FROM invoices WHERE airline_id = ?1", nativeQuery = true)
    double sumKgByAirlineId(int theId);

    @Query(value = "SELECT SUM(totalPrice) FROM invoices WHERE airline_id = ?1", nativeQuery = true)
    double sumValueByAirlineId(int theId);

    /*
     *  Query for total sum
     */

    @Query(value = "SELECT SUM(upliftLit) FROM invoices", nativeQuery = true)
    Double sumTotalLit();

    @Query(value = "SELECT SUM(upliftKg) FROM invoices", nativeQuery = true)
    Double sumTotalKg();

    @Query(value = "SELECT SUM(totalPrice) FROM invoices", nativeQuery = true)
    Double sumTotalValue();

}
