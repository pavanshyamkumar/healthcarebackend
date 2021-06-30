package com.project.HealthCare.Services;

import java.util.Date;
import java.util.Set;


import com.project.HealthCare.model.Doctor;

public interface DoctorService {
	
	public Doctor savedoctor(Doctor doc);
	
	public void del(Long id);
	
	public Set<Doctor> getall();
	
	public Doctor getbyid(Long did);
	
	public Doctor update(Doctor doc);
	
	public Set<Doctor> getappbydate(Long did, Date date);

}
