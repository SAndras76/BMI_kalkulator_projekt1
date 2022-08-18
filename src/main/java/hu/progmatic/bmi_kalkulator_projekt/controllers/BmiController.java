package hu.progmatic.bmi_kalkulator_projekt.controllers;

import hu.progmatic.bmi_kalkulator_projekt.models.BmiModel;
import hu.progmatic.bmi_kalkulator_projekt.services.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BmiController {

    private BmiService bmiService;


    @Autowired
    public BmiController(BmiService bmiService){
        this.bmiService = bmiService;
    }
    @GetMapping(value = "/newperson")
    public String MainPage (Model model) {
        BmiModel bmiModel = new BmiModel();
        model.addAttribute("newdata", bmiModel);

        return "newperson";
    }
    @GetMapping(value = "/result")
    public String eredmeny (Model model) {
        BmiModel bmiModel = new BmiModel();
        model.addAttribute("result", bmiModel);
        return "result";
    }
}
