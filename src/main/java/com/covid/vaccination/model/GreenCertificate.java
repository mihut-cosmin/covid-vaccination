package com.covid.vaccination.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "green_certificates")
public class GreenCertificate extends BaseEntity{

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "certificate_id")
    private String certificateId;

    @OneToOne(targetEntity = VaccinationEvent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccination_id", referencedColumnName = "id")
    private VaccinationEvent vaccinationEvent;

    @OneToOne(targetEntity = RecoveryEvent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recovery_id", referencedColumnName = "id")
    private RecoveryEvent recoveryEvent;

    @OneToOne(targetEntity = TestEvent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private TestEvent testEvent;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public VaccinationEvent getVaccinationEvent() {
        return vaccinationEvent;
    }

    public void setVaccinationEvent(VaccinationEvent vaccinationEvent) {
        this.vaccinationEvent = vaccinationEvent;
    }

    public RecoveryEvent getRecoveryEvent() {
        return recoveryEvent;
    }

    public void setRecoveryEvent(RecoveryEvent recoveryEvent) {
        this.recoveryEvent = recoveryEvent;
    }

    public TestEvent getTestEvent() {
        return testEvent;
    }

    public void setTestEvent(TestEvent testEvent) {
        this.testEvent = testEvent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
