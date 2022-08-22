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
@RequestMapping("eredmenyek")
public class BmiController {

    private BmiService bmiService;
    private static List<String> eredmenyek = new ArrayList<>();

    @Autowired
    public BmiController(BmiService bmiService){
        this.bmiService = bmiService;
    }

    @GetMapping("eredmenyek")
    public String displayEredmenyek(Model model){
        model.addAttribute("eredmenyek", eredmenyek);
                return "result";
    }
    @GetMapping(value = "/newperson")
    public String MainPage (Model model) {
        BmiModel bmiModel = new BmiModel();
        model.addAttribute("newdata", bmiModel);

        return "newperson";
    }





    @PostMapping(value = "/result")
    public String eredmeny (@RequestParam String name, double height, double kgs ) {
        //BmiModel bmiModel = new BmiModel();
        //double calculateBMI = BmiService.;
        eredmenyek.add(name);

        return "result";
    }
}
