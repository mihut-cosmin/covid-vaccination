package com.covid.vaccination.controller;

import com.covid.vaccination.model.*;
import com.covid.vaccination.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class GreenCertificateController {

    @Autowired
    private GreenCertificateService greenCertificateService;

    @Autowired
    private UserService userService;

    @Autowired
    private VaccinationEventService vaccinationEventService;

    @Autowired
    private RecoveryEventService recoveryEventService;

    @Autowired
    private TestEventService testEventService;

    @GetMapping("showNewGreenCertificateForm")
    public String showNewGreenCertificateForm(Model model) {
        GreenCertificate greenCertificate = new GreenCertificate();
        List<User> users = userService.getAllUsers();
        model.addAttribute("greenCertificate", greenCertificate);
        model.addAttribute("users", users);
        return "new_green_certificate";
    }

    @GetMapping("showGreenCertificateVerification")
    public String showGreenCertificateVerification(Model model) {
        GreenCertificate greenCertificate = new GreenCertificate();
        model.addAttribute("greenCertificate", greenCertificate);
        return "show_verify_green_certificate";
    }

    @PostMapping("/verifyGreenCertificate")
    public String verifyGreenCertificateForm(@ModelAttribute("greenCertificate") GreenCertificate greenCertificate, Model model) {
        GreenCertificate validateGreenCertificate = greenCertificateService.getGreenCertificateByCertificateId(greenCertificate.getCertificateId());
        if (validateGreenCertificate == null) {
            String errorMsg = "No green certificate was found for this user";
            model.addAttribute("errorMsg", errorMsg);
            return "error_generate_green_certificate";
        }
        String validity = validateGreenCertificate.getEndDate().after(new Date()) ? "VALID" : "INVALID";
        model.addAttribute("greenCertificate", validateGreenCertificate);
        model.addAttribute("validity", validity);
        return "success_green_certificate";
    }

    @PostMapping("/generateGreenCertificate")
    public String generateGreenCertificate(@ModelAttribute("greenCertificate")GreenCertificate greenCertificate, Model model) {
        User user = greenCertificate.getUser();
        List<VaccinationEvent> vaccinationEvents = vaccinationEventService.getVaccinationEventsByUserId(user.getId().intValue());
        VaccinationEvent vaccinationEvent = vaccinationEvents.size() > 0 ? vaccinationEvents.get(0) : null;
        List<RecoveryEvent> recoveryEvents = recoveryEventService.getRecoveryEventsByUserId(user.getId().intValue());
        RecoveryEvent recoveryEvent = recoveryEvents.size() > 0 ? recoveryEvents.get(0) : null;
        List<TestEvent> testEvents = testEventService.getTestEventsByUserId(user.getId().intValue());
        TestEvent testEvent = testEvents.size() > 0 ? testEvents.get(0) : null;
        Calendar calendar = Calendar.getInstance();
        if(vaccinationEvent != null && (vaccinationEvent.getVaccine().getName().equals("Janssen") || (!vaccinationEvent.getVaccine().getName().equals("Janssen") && (vaccinationEvent.getDoseNumber() == 2)))) {
            greenCertificate.setStartDate(vaccinationEvent.getDate());
            calendar.setTime(greenCertificate.getStartDate());
            calendar.add(Calendar.YEAR, 1);
            greenCertificate.setVaccinationEvent(vaccinationEvent);
        } else if (recoveryEvent != null) {
            greenCertificate.setStartDate(recoveryEvent.getDate());
            calendar.setTime(greenCertificate.getStartDate());
            calendar.add(Calendar.DATE, 180);
            greenCertificate.setRecoveryEvent(recoveryEvent);
        } else if (testEvent != null && testEvent.getResult().equals("Negative")) {
            greenCertificate.setStartDate(testEvent.getDate());
            calendar.setTime(greenCertificate.getStartDate());
            calendar.add(Calendar.HOUR, 72);
            greenCertificate.setTestEvent(testEvent);
        } else {
            String errorMsg = "Unable to generate green certificate as user has no valid vaccination, recovery or test event.";
            model.addAttribute("errorMsg", errorMsg);
            return "error_generate_green_certificate";
        }
        greenCertificate.setEndDate(calendar.getTime());
        String certificate_id = greenCertificateService.randomUUID(16, 4, '-');
        GreenCertificate verifyCertificate = greenCertificateService.getGreenCertificateByCertificateId(certificate_id);
        while (verifyCertificate != null) {
            certificate_id = greenCertificateService.randomUUID(16, 4, '-');
            verifyCertificate = greenCertificateService.getGreenCertificateByCertificateId(certificate_id);
        }
        greenCertificate.setCertificateId(certificate_id);
        greenCertificateService.generateGreenCertificate(greenCertificate);
        model.addAttribute("greenCertificate", greenCertificate);
        String validity = greenCertificate.getEndDate().after(new Date()) ? "VALID" : "INVALID";
        model.addAttribute("validity", validity);
        return "success_green_certificate";
    }



}
