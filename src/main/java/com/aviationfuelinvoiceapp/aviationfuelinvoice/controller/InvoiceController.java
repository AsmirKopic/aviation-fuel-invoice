package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.export.InvoiceDataPdfExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String save(@ModelAttribute("invoice") Invoice theInvoice, @ModelAttribute("airline") Airline theAirline){

        double price = theAirline.getDifferential() / 1000;
        double totalPrice = price * theInvoice.getUpliftKg();
        theInvoice.setPrice(price);
        theInvoice.setTotalPrice(totalPrice);

        invoiceService.save(theInvoice);

        return "redirect:/invoices/list";
   }

   @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(@RequestParam("invoiceId") int theId, Model theModel){

        Invoice theInvoice = invoiceService.findById(theId);
        theModel.addAttribute("invoice", theInvoice);

        List<Airline> theAirlines = airlineService.findAll();
        theModel.addAttribute("airlines", theAirlines);

        return "invoices/invoice-form";
   }

   @GetMapping("/delete")
   public String delete(@RequestParam("invoiceId") int theId){

        invoiceService.deleteById(theId);

        return "redirect:/invoices/list";
   }

    @GetMapping("/search")
    public String search(@RequestParam("invoiceNumber") int theId, Model theModel){

        List<Invoice> result = invoiceService.searchById(theId);
        theModel.addAttribute("invoices", result);

        return "invoices/list-invoices";
    }

   @GetMapping("/showInvoice")
   public String showInvoice(@RequestParam("invoiceId") int theId, Model theModel){

        Invoice theInvoice = invoiceService.findById(theId);
        Airline theAirline = airlineService.findById(theInvoice.getAirline().getAirlineId());
        theModel.addAttribute("invoice", theInvoice);
        // theModel.addAttribute("airline", theAirline);

        return "invoices/invoice";
   }

    @GetMapping("/pdf")
    public ModelAndView exportToPdf(@RequestParam("invoiceId") int theId) {
        ModelAndView mav = new ModelAndView();
        mav.setView(new InvoiceDataPdfExport());
        //read data from DB
        Invoice theInvoice = invoiceService.findById(theId);
        //send to pdfImpl class
        mav.addObject("invoice", theInvoice);

        return mav;
    }

}
