package com.covid.vaccination.service;

import com.covid.vaccination.model.Vaccine;

import java.util.List;

public interface VaccineService {

    List<Vaccine> getAllVaccines();

    Vaccine getVaccineById(Long id);
}
