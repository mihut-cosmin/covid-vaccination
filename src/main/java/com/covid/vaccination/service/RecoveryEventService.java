package com.covid.vaccination.service;

import com.covid.vaccination.model.RecoveryEvent;

import java.util.List;

public interface RecoveryEventService {

    List<RecoveryEvent> getAllRecoveryEvents();

    void saveRecoveryEvent(RecoveryEvent recoveryEvent);
}
