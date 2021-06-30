package com.project.HealthCare.Repository;


import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;



import com.project.HealthCare.model.Appointment;
import com.project.HealthCare.model.Doctor;
import com.project.HealthCare.model.Patient;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

	Set<Appointment> findByPatient(Patient patient);

	Set<Appointment> findByDoctor(Doctor doctor);
	
	Set<Appointment> findByDoctorAndDate(Doctor doctor,Date date);
	
	
	


}
