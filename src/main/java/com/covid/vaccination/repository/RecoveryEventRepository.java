package com.covid.vaccination.repository;

import com.covid.vaccination.model.RecoveryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryEventRepository extends JpaRepository<RecoveryEvent, Long> {
    
}
