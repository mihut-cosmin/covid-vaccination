package com.covid.vaccination.service;

import com.covid.vaccination.model.GreenCertificate;

import java.util.List;

public interface GreenCertificateService {

    List<GreenCertificate> getAllGreenCertificates();

    GreenCertificate getGreenCertificateByCertificateId(String certificate_id);

    void generateGreenCertificate(GreenCertificate greenCertificate);

    boolean isGreenCertificateValid(GreenCertificate greenCertificate);

    String randomUUID(int length, int spacing, char spacerChar);
}
