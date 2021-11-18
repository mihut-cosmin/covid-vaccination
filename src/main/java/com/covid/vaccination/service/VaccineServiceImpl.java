package com.covid.vaccination.service;

import com.covid.vaccination.model.Vaccine;
import com.covid.vaccination.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public Vaccine getVaccineById(Long id) { return vaccineRepository.getById(id);}
}
