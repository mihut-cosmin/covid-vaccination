package com.covid.vaccination.service;

import com.covid.vaccination.model.VaccinationEvent;

import java.util.List;

public interface VaccinationEventService {

    List<VaccinationEvent> getAllVaccinationEvents();

    void saveVaccinationEvent(VaccinationEvent vaccinationEvent);

    List<VaccinationEvent> getVaccinationEventsByUserId(int user_id);
}
