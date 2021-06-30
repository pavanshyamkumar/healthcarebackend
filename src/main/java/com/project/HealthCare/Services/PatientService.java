package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.Patient;

public interface PatientService  {
	
	public Patient savepat(Patient pat);
	
	public void del(Long pid);
	
	public Set<Patient> getall();
	
	public Patient getbyid(Long pid);
	

}
