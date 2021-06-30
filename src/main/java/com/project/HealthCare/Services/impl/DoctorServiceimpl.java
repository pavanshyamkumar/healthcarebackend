package com.project.HealthCare.Services.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HealthCare.Repository.DoctorRepo;
import com.project.HealthCare.Services.DoctorService;

import com.project.HealthCare.model.Doctor;

@Service
public class DoctorServiceimpl implements DoctorService {
	
	@Autowired
	private DoctorRepo repo;

	@Override
	public Doctor savedoctor(Doctor doc) {
		
		return this.repo.save(doc);
	}

	@Override
	public void del(Long id) {
		this.repo.deleteById(id);
		
	}

	@Override
	public Set<Doctor> getall() {
		
		return new HashSet<>(this.repo.findAll());
	}

	@Override
	public Doctor getbyid(Long did) {
		
		return this.repo.findById(did).orElse(null);
	}

	@Override
	public Doctor update(Doctor doc) {
		// TODO Auto-generated method stub
		return this.repo.save(doc);
	}

	@Override
	public Set<Doctor> getappbydate(Long did, Date date) {
		
		return new HashSet<>(this.repo.findByDidAndDate(did, date));
	}

	
}
