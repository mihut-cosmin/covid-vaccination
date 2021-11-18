package com.covid.vaccination.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recovery_events")
public class RecoveryEvent extends BaseEntity {

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
