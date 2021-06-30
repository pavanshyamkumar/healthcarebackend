package com.project.HealthCare.Repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.HealthCare.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
	
	public Set<Doctor> findByDidAndDate(Long did, Date date);

}
