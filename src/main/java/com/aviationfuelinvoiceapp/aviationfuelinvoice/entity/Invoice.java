package com.aviationfuelinvoiceapp.aviationfuelinvoice.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer invoiceId;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airline airline;

    @Column(name = "upliftKg")
    private Double upliftKg;

    @Column(name = "upliftLit")
    private Double upliftLit;

    @Column(name = "ticketNumber")
    private String ticketNumber;

    @Column(name = "flightNumber")
    private String flightNumber;

    @Column(name = "aircraftRegistration")
    private String aircraftRegistration;

    @Column(name = "aircraftType")
    private String aircraftType;

    @Column(name = "authorizationNote")
    private String authorizationNote;


    public Invoice() {

    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Double getUpliftKg() {
        return upliftKg;
    }

    public void setUpliftKg(Double upliftKg) {
        this.upliftKg = upliftKg;
    }

    public Double getUpliftLit() {
        return upliftLit;
    }

    public void setUpliftLit(Double upliftLit) {
        this.upliftLit = upliftLit;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAuthorizationNote() {
        return authorizationNote;
    }

    public void setAuthorizationNote(String authorizationNote) {
        this.authorizationNote = authorizationNote;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", date='" + date + '\'' +
                ", airline=" + airline +
                ", upliftKg=" + upliftKg +
                ", upliftLit=" + upliftLit +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", aircraftRegistration='" + aircraftRegistration + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", authorizationNote='" + authorizationNote + '\'' +
                '}';
    }
}
