package com.project.HealthCare.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HealthCare.Services.AppointmentService;
import com.project.HealthCare.model.Appointment;
import com.project.HealthCare.model.Doctor;
import com.project.HealthCare.model.Patient;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {

	@Autowired
	private AppointmentService appser;

	@PostMapping("/save")
	public Appointment saveapp(@RequestBody Appointment appo) {
		return this.appser.saveappo(appo);
	}

	@DeleteMapping("/del/{appid}")
	public void deleteappo(@PathVariable("appid") Long appid) {
		this.appser.deletebyid(appid);

	}

	@GetMapping("/patient/{patientid}")
	public ResponseEntity<?> getappointmentsbypatient(@PathVariable("patientid") Long patientid) {
		Patient pat = new Patient();
		pat.setPid(patientid);
		Set<Appointment> appointmentsofpatients = this.appser.getappointmentsbypatients(pat);
		return ResponseEntity.ok(appointmentsofpatients);
	}

	@GetMapping("doctor/{doctorid}")
	public ResponseEntity<?> getappointmentsbydoctors(@PathVariable("doctorid") Long doctorid) {
		Doctor doc = new Doctor();
		doc.setDid(doctorid);
		Set<Appointment> getappointmentbydoctor = this.appser.getappointmentsbydoctor(doc);
		return ResponseEntity.ok(getappointmentbydoctor);
	}

	@GetMapping("{appid}")
	public Appointment getbyid(@PathVariable("appid") Long appid) {
		return this.appser.getbyid(appid);
	}

	@GetMapping("/getall")
	public Set<Appointment> getall() {
		return this.appser.getall();
	}
	
	@PostMapping("/check")
	public Set<Appointment> getbydate(@RequestBody Appointment appo)
	{
		Doctor doc = new Doctor();
		doc.setDid(appo.getDoctor().getDid());
		return this.appser.getbydate(doc, appo.getDate());
	}
	
	@PutMapping("/")
	public Appointment update(@RequestBody Appointment appo)
	{
		return this.appser.update(appo);
	}


}
