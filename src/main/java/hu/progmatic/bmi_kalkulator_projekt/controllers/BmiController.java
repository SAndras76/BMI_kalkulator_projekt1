package hu.progmatic.bmi_kalkulator_projekt.controllers;

import hu.progmatic.bmi_kalkulator_projekt.services.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BmiController {

    private BmiService bmiService;


    @Autowired
    public BmiController(BmiService bmiService){
        this.bmiService = bmiService;
    }
}
