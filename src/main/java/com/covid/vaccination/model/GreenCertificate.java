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
}
