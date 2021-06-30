package com.project.HealthCare.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	private Long did;
	private String name;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	private String degignation;
	private String decpription;
	private String firstname;
	private String lastname;
	private String mobilenumber;
	private String age;
	private String sex;
	private String qualification;
	private String experience;
	private String department;
	private String locality;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Appointment> appointment = new LinkedHashSet<>();

	public Doctor() {

	}

	public Doctor(Long did, String name, Date date, String degignation, String decpription, String firstname,
			String lastname, String mobilenumber, String age, String sex, String qualification, String experience,
			String department, String locality, Set<Appointment> appointment) {
		super();
		this.did = did;
		this.name = name;
		this.date = date;
		this.degignation = degignation;
		this.decpription = decpription;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.age = age;
		this.sex = sex;
		this.qualification = qualification;
		this.experience = experience;
		this.department = department;
		this.locality = locality;
		this.appointment = appointment;
	}
	
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getDegignation() {
		return degignation;
	}

	public void setDegignation(String degignation) {
		this.degignation = degignation;
	}

	public String getDecpription() {
		return decpription;
	}

	public void setDecpription(String decpription) {
		this.decpription = decpription;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

}
