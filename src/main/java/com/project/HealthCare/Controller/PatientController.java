package com.project.HealthCare.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HealthCare.Services.PatientService;
import com.project.HealthCare.model.Patient;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {
	
	@Autowired
	public PatientService patser;
	
	
	@GetMapping("/getall")
	public Set<Patient> getall()
	{
		return this.patser.getall();
	}
	
	@DeleteMapping("/{pid}")
	public void del(@PathVariable("pid") Long pid)
	{
		this.patser.del(pid);
	}
	
	@GetMapping("/{pid}")
	public Patient getbyid(@PathVariable("pid") Long pid)
	{
		return this.patser.getbyid(pid);
	}

}
