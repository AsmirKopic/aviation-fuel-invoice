package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airlines")
public class AirlineController {

    AirlineService airlineService;
    InvoiceService invoiceService;

    @Autowired
    public AirlineController(AirlineService airlineService, InvoiceService invoiceService) {
        this.airlineService = airlineService;
        this.invoiceService = invoiceService;
    }

    @RequestMapping("/list")
    public String listAirlines(Model theModel){

        List<Airline> airlines = airlineService.findAll();

        theModel.addAttribute("airlines", airlines);

        return "airlines/list-airlines";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Airline theAirline = new Airline();

        theModel.addAttribute("airline", theAirline);

        return "airlines/airline-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("airline") Airline theAirline){

        airlineService.save(theAirline);

        return "redirect:/airlines/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("airlineId") int theId, Model theModel) {

        Airline theAirline = airlineService.findById(theId);
        theModel.addAttribute("airline", theAirline);

        return "airlines/airline-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("airlineId") int theId){
        airlineService.deleteById(theId);

        return "redirect:/airlines/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("airlineName") String airlineName, Model theModel){

        List<Airline> result = airlineService.searchByName(airlineName);
        theModel.addAttribute("airlines", result);

        return "airlines/list-airlines";
    }

    @GetMapping("/showInfo")
    public String showInfo(@RequestParam("airlineId") int theId, Model theModel) {

        Airline theAirline = airlineService.findById(theId);
        theModel.addAttribute("airline", theAirline);

        List<Invoice> invoiceList = invoiceService.findByAirlineId(theId);
        theModel.addAttribute("invoices", invoiceList);

        return "airlines/airline-info";
    }


}
