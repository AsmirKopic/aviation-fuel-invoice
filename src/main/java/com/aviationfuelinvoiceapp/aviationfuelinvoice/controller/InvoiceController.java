package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
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

        return "invoices/invoice-form";
   }

   @PostMapping("/save")
    public String save(@ModelAttribute("invoice") Invoice theInvoice){

        invoiceService.save(theInvoice);

        return "redirect:/invoices/list";
   }

}
