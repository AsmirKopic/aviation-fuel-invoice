package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    InvoiceService invoiceService;
    AirlineService airlineService;

    @Autowired
    public DashboardController(InvoiceService invoiceService, AirlineService airlineService) {
        this.invoiceService = invoiceService;
        this.airlineService = airlineService;
    }


    public String overview(Model theModel){

        List<Airline> theAirlines = airlineService.findAll();

        // continue impl.



        return null;
    }


}
