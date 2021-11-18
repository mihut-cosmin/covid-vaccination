package com.covid.vaccination.repository;

import com.covid.vaccination.model.VaccinationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationEventRepository extends JpaRepository<VaccinationEvent, Long> {

    @Query("FROM VaccinationEvent WHERE user_id = :id ORDER BY date DESC")
    List<VaccinationEvent> findByUserId(int id);

}
