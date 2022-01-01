package com.aviationfuelinvoiceapp.aviationfuelinvoice.dao;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
