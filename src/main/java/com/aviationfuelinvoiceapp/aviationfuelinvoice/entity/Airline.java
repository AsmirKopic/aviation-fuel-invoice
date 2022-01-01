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
    private Double differential;

    @Column(name = "payment_terms")
    private Integer paymentTerms;

    @OneToMany(mappedBy="airline",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Invoice> invoices;

    public Airline() {

    }

    public Airline(String name, String address, String email, Double differential, Integer paymentTerms, List<Invoice> invoices) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.differential = differential;
        this.paymentTerms = paymentTerms;
        this.invoices = invoices;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getDifferential() {
        return differential;
    }

    public void setDifferential(Double differential) {
        this.differential = differential;
    }

    public Integer getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(Integer paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", differential=" + differential +
                ", paymentTerms=" + paymentTerms +
                ", invoices=" + invoices +
                '}';
    }
}
