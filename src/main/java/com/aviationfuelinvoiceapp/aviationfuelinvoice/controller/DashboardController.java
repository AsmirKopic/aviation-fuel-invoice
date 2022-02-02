package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class DashboardController {

    InvoiceService invoiceService;
    AirlineService airlineService;

    @Autowired
    public DashboardController(InvoiceService invoiceService, AirlineService airlineService) {
        this.invoiceService = invoiceService;
        this.airlineService = airlineService;
    }

    @GetMapping
    public String overview(Model theModel){

        Double sumTotalKg = invoiceService.sumTotalKg();
        Double sumTotalLit = invoiceService.sumTotalLit();
        Double sumTotalValue = invoiceService.sumTotalValue();

        theModel.addAttribute("totalKg", sumTotalKg);
        theModel.addAttribute("totalLit", sumTotalLit);
        theModel.addAttribute("totalValue", sumTotalValue);

        return "/dashboard/dashboard";
    }

}
