package com.covid.vaccination.model;

import javax.persistence.*;

@Entity
@Table(name = "vaccines")
public class Vaccine extends BaseEntity{
	
	private String name;
	
	private int doses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}
}
