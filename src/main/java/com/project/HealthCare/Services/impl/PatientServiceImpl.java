package com.project.HealthCare.Services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HealthCare.Repository.PatientRepo;
import com.project.HealthCare.Services.PatientService;
import com.project.HealthCare.model.Patient;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepo repopat;

	@Override
	public Patient savepat(Patient pat) {
		// TODO Auto-generated method stub
		return this.repopat.save(pat);
	}

	@Override
	public void del(Long pid) {
		this.repopat.deleteById(pid);
		
	}

	@Override
	public Set<Patient> getall() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.repopat.findAll());
	}

	@Override
	public Patient getbyid(Long pid) {
		// TODO Auto-generated method stub
		return this.repopat.findById(pid).orElse(null);
	}

	

}
