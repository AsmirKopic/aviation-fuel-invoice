package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.view.InvoiceDataPdfExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

   @GetMapping("/showInvoice")
   public String showInvoice(@RequestParam("invoiceId") int theId, Model theModel){

        Invoice theInvoice = invoiceService.findById(theId);
        Airline theAirline = airlineService.findById(theInvoice.getAirline().getAirlineId());
        theModel.addAttribute("invoice", theInvoice);
        // theModel.addAttribute("airline", theAirline);

        return "invoices/invoice";
   }

    @GetMapping("/pdf")
    public ModelAndView exportToPdf() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new InvoiceDataPdfExport());
        //read data from DB
        Invoice theInvoice = invoiceService.findById(13);
        //send to pdfImpl class
        mav.addObject("invoice", theInvoice);
        return mav;
    }

}
