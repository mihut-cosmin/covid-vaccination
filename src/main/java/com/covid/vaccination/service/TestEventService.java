package com.covid.vaccination.service;

import com.covid.vaccination.model.TestEvent;

import java.util.List;

public interface TestEventService {

    List<TestEvent> getAllTestEvents();

    void saveTestEvent(TestEvent testEvent);

    List<TestEvent> getTestEventsByUserId(int user_id);
}
