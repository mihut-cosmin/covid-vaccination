package com.covid.vaccination.service;

import com.covid.vaccination.model.TestEvent;
import com.covid.vaccination.repository.TestEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestEventServiceImpl implements TestEventService {

    @Autowired
    private TestEventRepository testEventRepository;

    @Override
    public List<TestEvent> getAllTestEvents() {
        return testEventRepository.findAll();
    }

    @Override
    public void saveTestEvent(TestEvent testEvent) {
        this.testEventRepository.save(testEvent);
    }

    @Override
    public List<TestEvent> getTestEventsByUserId(int user_id) {
        return testEventRepository.findByUserId(user_id);
    }
}
