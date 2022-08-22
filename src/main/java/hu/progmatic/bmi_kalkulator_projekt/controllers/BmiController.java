package hu.progmatic.bmi_kalkulator_projekt.controllers;

import hu.progmatic.bmi_kalkulator_projekt.models.BmiModel;
import hu.progmatic.bmi_kalkulator_projekt.services.BmiService;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BmiController {

    private BmiService bmiService;
    private static List<String> eredmenyek = new ArrayList<>();

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




    @PostMapping(value = "/result")
    public String eredmeny (BmiModel bmiModel, Model model) {

        double heihtInMeter = bmiModel.getHeight()/100;
        double resultBMI = bmiService.calculateBMI(bmiModel);
        String status = bmiService.getBMIStatus(resultBMI);
        //Math.ceil(bmiModel.getKgs() / (heihtInMeter * heihtInMeter));
        model.addAttribute("calculateBMI", resultBMI);
        model.addAttribute("status", status);

        return "result";
    }
}
