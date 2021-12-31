package com.aviationfuelinvoiceapp.aviationfuelinvoice.controller;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Airline;
import com.aviationfuelinvoiceapp.aviationfuelinvoice.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airlines")
public class AirlineController {

    private AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/list")
    public String listAirlines(Model theModel){

        List<Airline> airlines = airlineService.findAll();

        theModel.addAttribute("airlines", airlines);

        return "airlines/list-airlines";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Airline theAirline = new Airline();

        theModel.addAttribute("airline", theAirline);

        return "/airlines/airline-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("airline") Airline theAirline){

        airlineService.save(theAirline);

        return "redirect:/airlines/list";
    }



}
