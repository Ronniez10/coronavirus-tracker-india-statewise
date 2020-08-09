package com.neelav.coronavirousindiastatewisetracker.controller;

import com.neelav.coronavirousindiastatewisetracker.models.CoronaData;
import com.neelav.coronavirousindiastatewisetracker.service.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CoronaDataService coronaDataService;

    @GetMapping("/")
    public String home(Model model)
    {
        int sum=0;
        List<CoronaData> getAllStats= coronaDataService.getStateData();
        CoronaData totalData = getAllStats.get(0);
        int totalConfirmedCases = totalData.getConfirmed();
        int totalRecovered = totalData.getRecovered();
        int totalActive = totalData.getActive();
        int totalDeaths = totalData.getDeaths();

        List<CoronaData> stateWiseList = getAllStats.subList(1,getAllStats.size());

        model.addAttribute("totalConfirmed",totalConfirmedCases);
        model.addAttribute("totalRecovered",totalRecovered);
        model.addAttribute("totalDeaths",totalDeaths);
        model.addAttribute("totalActive",totalActive);
        model.addAttribute("stateWiseList",stateWiseList);

        return "home";
    }
}
