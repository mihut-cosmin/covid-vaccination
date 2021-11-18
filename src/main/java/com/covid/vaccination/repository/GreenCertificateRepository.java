package com.covid.vaccination.repository;

import com.covid.vaccination.model.GreenCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenCertificateRepository extends JpaRepository<GreenCertificate, Long> {

    @Query("FROM GreenCertificate WHERE certificate_id = :certificate_id")
    GreenCertificate findByCertificateId(String certificate_id);
}
