package com.covid.vaccination.repository;

import com.covid.vaccination.model.RecoveryEvent;
import com.covid.vaccination.model.VaccinationEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecoveryEventRepository extends JpaRepository<RecoveryEvent, Long> {

    @Query("FROM RecoveryEvent WHERE user_id = :id ORDER BY date DESC")
    List<RecoveryEvent> findByUserId(int id);

}
