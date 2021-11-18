package com.covid.vaccination.controller;

import com.covid.vaccination.model.User;
import com.covid.vaccination.model.VaccinationEvent;
import com.covid.vaccination.model.Vaccine;
import com.covid.vaccination.service.UserService;
import com.covid.vaccination.service.VaccinationEventService;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VaccinationEventController {

    @Autowired
    private VaccinationEventService vaccinationEventService;

    @Autowired
    private UserService userService;

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/showNewVaccinationEventForm")
    public String showNewVaccinationEventForm(Model model) {
        List<User> users = userService.getAllUsers();
        List<Vaccine> vaccines = vaccineService.getAllVaccines();
        VaccinationEvent vaccinationEvent = new VaccinationEvent();
        model.addAttribute("vaccinationEvent", vaccinationEvent);
        model.addAttribute("users", users);
        model.addAttribute("vaccines", vaccines);
        return "new_vaccination_event";
    }

    @PostMapping("/saveVaccinationEvent")
    public String saveVaccinationEvent(@ModelAttribute("vaccinationEvent") VaccinationEvent vaccinationEvent) {
        vaccinationEventService.saveVaccinationEvent(vaccinationEvent);
        return "redirect:/";
    }
}
