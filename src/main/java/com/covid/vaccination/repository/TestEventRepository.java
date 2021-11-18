package com.covid.vaccination.repository;

import com.covid.vaccination.model.TestEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEventRepository extends JpaRepository<TestEvent, Long> {

}
