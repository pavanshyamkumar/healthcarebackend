package com.project.HealthCare.Services;


import java.util.Date;
import java.util.Set;

import com.project.HealthCare.model.Appointment;
import com.project.HealthCare.model.Doctor;
import com.project.HealthCare.model.Patient;

public interface AppointmentService {

	public Appointment saveappo(Appointment app);

	public void deletebyid(Long appid);

	public Set<Appointment> getappointmentsbypatients(Patient patient);

	public Set<Appointment> getappointmentsbydoctor(Doctor doctor);

	public Set<Appointment> getall();
	
	public Set<Appointment> getbydate(Doctor doctor,Date date);
	
	public Appointment update(Appointment appo);

	public Appointment getbyid(Long appid);

}
