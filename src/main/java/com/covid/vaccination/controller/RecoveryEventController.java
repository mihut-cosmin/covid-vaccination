package com.covid.vaccination.controller;

import com.covid.vaccination.model.RecoveryEvent;
import com.covid.vaccination.model.User;
import com.covid.vaccination.service.RecoveryEventService;
import com.covid.vaccination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecoveryEventController {

    @Autowired
    private RecoveryEventService recoveryEventService;

    @Autowired
    private UserService userService;

    @GetMapping("/showNewRecoveryEventForm")
    public String showNewRecoveryEventForm(Model model) {
        RecoveryEvent recoveryEvent = new RecoveryEvent();
        List<User> users = userService.getAllUsers();
        model.addAttribute("recoveryEvent", recoveryEvent);
        model.addAttribute("users", users);
        return "new_recovery_event";
    }

    @PostMapping("/saveRecoveryEvent")
    public String saveRecoveryEvent(@ModelAttribute("recoveryEvent") RecoveryEvent recoveryEvent) {
        recoveryEventService.saveRecoveryEvent(recoveryEvent);
        return "redirect:/";
    }
}
