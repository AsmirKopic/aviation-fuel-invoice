package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    InvoiceService invoiceService;
    AirlineService airlineService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, AirlineService airlineService) {
        this.invoiceService = invoiceService;
        this.airlineService = airlineService;
    }

    @RequestMapping("/list")
    public String listInvoices(Model theModel){

       List<Invoice> theInvoices = invoiceService.findAll();
       theModel.addAttribute("invoices", theInvoices);

       return "invoices/list-invoices";
   }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Invoice theInvoice = new Invoice();
        theModel.addAttribute("invoice", theInvoice);

       List<Airline> airlineList = airlineService.findAll();
       theModel.addAttribute("airlines", airlineList);

        return "invoices/invoice-form";
   }

   @PostMapping("/save")
    public String save(@ModelAttribute("invoice") Invoice theInvoice){

        invoiceService.save(theInvoice);

        return "redirect:/invoices/list";
   }

}
