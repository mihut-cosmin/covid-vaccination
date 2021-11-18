package com.covid.vaccination.service;

import com.covid.vaccination.model.VaccinationEvent;
import com.covid.vaccination.repository.VaccinationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationEventServiceImpl implements VaccinationEventService {

    @Autowired
    private VaccinationEventRepository vaccinationEventRepository;

    @Override
    public List<VaccinationEvent> getAllVaccinationEvents() {
        return vaccinationEventRepository.findAll();
    }

    @Override
    public void saveVaccinationEvent(VaccinationEvent vaccinationEvent) {
        this.vaccinationEventRepository.save(vaccinationEvent);
    }

    @Override
    public List<VaccinationEvent> getVaccinationEventsByUserId(int user_id) {
        return vaccinationEventRepository.findByUserId(user_id);
    }
}
