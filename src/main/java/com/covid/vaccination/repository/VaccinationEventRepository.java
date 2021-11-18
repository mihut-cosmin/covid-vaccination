package com.covid.vaccination.repository;

import com.covid.vaccination.model.VaccinationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationEventRepository extends JpaRepository<VaccinationEvent, Long> {

}
