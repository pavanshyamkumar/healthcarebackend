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

import com.project.HealthCare.Services.DoctorService;
import com.project.HealthCare.model.Doctor;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	private DoctorService docser;
	
	
	@DeleteMapping("/{did}")
	public void del(@PathVariable("did") Long did)
	{
		this.docser.del(did);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall()
	{
		return  ResponseEntity.ok(this.docser.getall());
	}
	
	@GetMapping("/{did}")
	public Doctor getbyid(@PathVariable("did") Long did)
	{
		return this.docser.getbyid(did);
	}
	
	@PutMapping("/")
	public Doctor update(@RequestBody Doctor doc)
	{
		return this.docser.update(doc);
	}
	
	@PostMapping("/check")
	public Set<Doctor> getbydate(@RequestBody Doctor doc)
	{
		return this.docser.getappbydate(doc.getDid(), doc.getDate());
	}
	
	

}
