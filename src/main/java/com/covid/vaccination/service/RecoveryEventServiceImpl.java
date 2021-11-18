package com.covid.vaccination.service;

import com.covid.vaccination.model.RecoveryEvent;
import com.covid.vaccination.repository.RecoveryEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryEventServiceImpl implements RecoveryEventService {

    @Autowired
    private RecoveryEventRepository recoveryEventRepository;

    @Override
    public List<RecoveryEvent> getAllRecoveryEvents() {
        return recoveryEventRepository.findAll();
    }

    @Override
    public void saveRecoveryEvent(RecoveryEvent recoveryEvent) {
        this.recoveryEventRepository.save(recoveryEvent);
    }

    @Override
    public List<RecoveryEvent> getRecoveryEventsByUserId(int user_id) {
        return recoveryEventRepository.findByUserId(user_id);
    }
}
