package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {

    @GetMapping("/home")
    public String demoMapping(){
        return "index";
    }
}
