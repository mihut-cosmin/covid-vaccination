package com.covid.vaccination.controller;

import com.covid.vaccination.model.TestEvent;
import com.covid.vaccination.model.User;
import com.covid.vaccination.service.TestEventService;
import com.covid.vaccination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestEventController {

    @Autowired
    private TestEventService testEventService;

    @Autowired
    private UserService userService;

    private static enum TestResults {
        Positive,
        Negative
    }

    @GetMapping("/showNewTestEventForm")
    public String showNewTestEventForm(Model model) {
        TestEvent testEvent = new TestEvent();
        List<User> users = userService.getAllUsers();
        model.addAttribute("testEvent", testEvent);
        model.addAttribute("users", users);
        model.addAttribute("possibleTestResults", TestResults.values());
        return "new_test_event";
    }

    @PostMapping("/saveTestEvent")
    public String saveTestEvent(@ModelAttribute("testEvent") TestEvent testEvent) {
        testEventService.saveTestEvent(testEvent);
        return "redirect:/";
    }
}
