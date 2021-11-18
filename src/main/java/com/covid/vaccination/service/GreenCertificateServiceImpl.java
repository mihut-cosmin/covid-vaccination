package com.covid.vaccination.service;

import com.covid.vaccination.model.GreenCertificate;
import com.covid.vaccination.repository.GreenCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class GreenCertificateServiceImpl implements GreenCertificateService{

    @Autowired
    private GreenCertificateRepository greenCertificateRepository;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private final Random range = new SecureRandom();

    @Override
    public List<GreenCertificate> getAllGreenCertificates() {
        return greenCertificateRepository.findAll();
    }

    @Override
    public GreenCertificate getGreenCertificateByCertificateId(String certificate_id) {
        return greenCertificateRepository.findByCertificateId(certificate_id);
    }

    @Override
    public void generateGreenCertificate(GreenCertificate greenCertificate) {
        this.greenCertificateRepository.save(greenCertificate);
    }

    @Override
    public boolean isGreenCertificateValid(GreenCertificate greenCertificate) {
        Date currentDate = new Date();
        return greenCertificate.getEndDate().before(currentDate);
    }

    private char randomChar() {
        return ALPHABET.charAt(range.nextInt(ALPHABET.length()));
    }

    @Override
    public String randomUUID(int length, int spacing, char spacerChar) {
        StringBuilder stringBuilder = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            if (spacer == spacing) {
                stringBuilder.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            stringBuilder.append(randomChar());
        }
        return stringBuilder.toString();
    }

}
