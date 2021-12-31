package com.aviationfuelinvoiceapp.aviationfuelinvoice.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int invoiceId;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="airline_name")
    private Airline airline;

    @Column(name = "upliftKg")
    private double upliftKg;

    @Column(name = "upliftLit")
    private double upliftLit;

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

    public Invoice(String date, Airline airline, double upliftKg, double upliftLit, String ticketNumber, String flightNumber, String aircraftRegistration, String aircraftType, String authorizationNote) {
        this.date = date;
        this.airline = airline;
        this.upliftKg = upliftKg;
        this.upliftLit = upliftLit;
        this.ticketNumber = ticketNumber;
        this.flightNumber = flightNumber;
        this.aircraftRegistration = aircraftRegistration;
        this.aircraftType = aircraftType;
        this.authorizationNote = authorizationNote;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
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

    public double getUpliftKg() {
        return upliftKg;
    }

    public void setUpliftKg(double upliftKg) {
        this.upliftKg = upliftKg;
    }

    public double getUpliftLit() {
        return upliftLit;
    }

    public void setUpliftLit(double upliftLit) {
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
}
