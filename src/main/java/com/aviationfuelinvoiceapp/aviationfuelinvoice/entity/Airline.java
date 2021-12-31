package com.aviationfuelinvoiceapp.aviationfuelinvoice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "diff")
    private double differential;

    @Column(name = "payment_terms")
    private int paymentTerms;

    @OneToMany(mappedBy="airline",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Invoice> invoices;

    public Airline(String name, String address, double differential, int paymentTerms) {
        this.name = name;
        this.address = address;
        this.differential = differential;
        this.paymentTerms = paymentTerms;
    }

    public Airline() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDifferential() {
        return differential;
    }

    public void setDifferential(double differential) {
        this.differential = differential;
    }

    public int getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(int paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", differential=" + differential +
                ", paymentTerms=" + paymentTerms +
                '}';
    }
}
