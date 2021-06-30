package com.project.HealthCare.Services.impl;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HealthCare.Repository.AppointmentRepo;
import com.project.HealthCare.Services.AppointmentService;
import com.project.HealthCare.model.Appointment;
import com.project.HealthCare.model.Doctor;
import com.project.HealthCare.model.Patient;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo apprepo;

	@Override
	public Appointment saveappo(Appointment app) {

		return this.apprepo.save(app);
	}

	@Override
	public void deletebyid(Long appid) {
		Appointment app = new Appointment();
		app.setApid(appid);
		this.apprepo.delete(app);
	}

	@Override
	public Set<Appointment> getappointmentsbypatients(Patient patient) {
		return this.apprepo.findByPatient(patient);
	}

	@Override
	public Set<Appointment> getappointmentsbydoctor(Doctor doctor) {

		return this.apprepo.findByDoctor(doctor);
	}

	@Override
	public Set<Appointment> getall() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.apprepo.findAll());
	}

	@Override
	public Appointment getbyid(Long appid) {
		// TODO Auto-generated method stub
		return this.apprepo.findById(appid).orElse(null);
	}

	@Override
	public Set<Appointment> getbydate(Doctor doctor, Date date) {
		
		return this.apprepo.findByDoctorAndDate(doctor, date);
	}

	@Override
	public Appointment update(Appointment appo) {
		// TODO Auto-generated method stub
		return this.apprepo.save(appo);
	}

	
	

}
