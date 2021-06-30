package com.project.HealthCare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long apid;

	private String name;

	private String age;

	private String weight;

	private String sex;

	private String problem;

	private String decription;

	private String precription;

	private boolean status=false;

	private boolean slot1=false;

	private boolean slot2=false;

	private boolean slot3=false;

	private boolean slot4=false;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.EAGER)
	private Patient patient;

	public Appointment() {

	}

	public Appointment(Long apid, String name, String age, String weight, String sex, String problem, String decription,
			String precription, boolean status, boolean slot1, boolean slot2, boolean slot3, boolean slot4, Date date,
			Doctor doctor, Patient patient) {
		super();
		this.apid = apid;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sex = sex;
		this.problem = problem;
		this.decription = decription;
		this.precription = precription;
		this.status = status;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.slot4 = slot4;
		this.date = date;
		this.doctor = doctor;
		this.patient = patient;
	}

	public boolean isSlot1() {
		return slot1;
	}

	public void setSlot1(boolean slot1) {
		this.slot1 = slot1;
	}

	public boolean isSlot2() {
		return slot2;
	}

	public void setSlot2(boolean slot2) {
		this.slot2 = slot2;
	}

	public boolean isSlot3() {
		return slot3;
	}

	public void setSlot3(boolean slot3) {
		this.slot3 = slot3;
	}

	public boolean isSlot4() {
		return slot4;
	}

	public void setSlot4(boolean slot4) {
		this.slot4 = slot4;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getApid() {
		return apid;
	}

	public void setApid(Long apid) {
		this.apid = apid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getPrecription() {
		return precription;
	}

	public void setPrecription(String precription) {
		this.precription = precription;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
