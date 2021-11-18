package com.covid.vaccination.controller;

import com.covid.vaccination.model.Vaccine;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/getVaccineDoses")
    @ResponseBody
    public int getVaccineDoses(int vaccine_id) {
        Vaccine vaccine = vaccineService.getVaccineById((long) vaccine_id);
        return vaccine.getDoses();
    }
}
