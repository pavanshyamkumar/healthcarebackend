package com.project.HealthCare.model;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	private Long pid;
	private String name;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Set<Appointment> appointment=new LinkedHashSet<>();
	
	
	public Patient() {
		
	}
	public Patient(Long pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	

}
