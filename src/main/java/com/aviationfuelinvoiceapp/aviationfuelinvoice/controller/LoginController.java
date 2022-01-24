package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/myLoginPage")
    public String myLoginPage(){
        return "index";
    }

    @GetMapping("acces-denied")
    public String accesDenied(){
        return "access-denied";
    }

}
