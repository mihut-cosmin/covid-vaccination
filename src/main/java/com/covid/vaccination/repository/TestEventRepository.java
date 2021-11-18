package com.covid.vaccination.repository;

import com.covid.vaccination.model.TestEvent;
import com.covid.vaccination.model.VaccinationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestEventRepository extends JpaRepository<TestEvent, Long> {

    @Query("FROM TestEvent WHERE user_id = :id ORDER BY date DESC")
    List<TestEvent> findByUserId(int id);

}
