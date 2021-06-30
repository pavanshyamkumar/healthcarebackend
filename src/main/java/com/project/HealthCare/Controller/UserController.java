package com.project.HealthCare.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.project.HealthCare.Services.PatientService;
import com.project.HealthCare.Services.UserService;
import com.project.HealthCare.model.Doctor;
import com.project.HealthCare.model.Patient;
import com.project.HealthCare.model.Role;
import com.project.HealthCare.model.User;
import com.project.HealthCare.model.UserRole;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private DoctorService doctorservice;
	
	@Autowired
	private PatientService patser;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@PostMapping("/createuserdoc")
	public Doctor usercreatedoc(@RequestBody User uc) throws Exception {
		
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(42L);
		r.setRolename("DOCTOR");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		
		this.userservice.createuser(uc, ur);
		
		User hf=new User();
		hf=this.userservice.userbyname(uc.getUsername());
		
		Doctor kkk=new Doctor();
		kkk.setDid(hf.getId());
		
		
		kkk.setName(uc.getUsername());
		kkk.setDegignation(uc.getDesignation());
		kkk.setFirstname(uc.getFirstname());
		kkk.setLastname(uc.getLastname());
		kkk.setMobilenumber(uc.getMobilenumber());
		
		kkk.setQualification(uc.getQualification());
		
		kkk.setExperience(uc.getExperience());
		
		kkk.setLocality(uc.getLocality());
		
		kkk.setDepartment(uc.getDepartment());
		
		kkk.setSex(uc.getSex());
		
		
		
		
		return this.doctorservice.savedoctor(kkk);
		
		
		
	}
	
	@PostMapping("/createuserpat")
	public Patient usercreatepat(@RequestBody User uc) throws Exception {
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(43L);
		r.setRolename("PATIENT");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		this.userservice.createuser(uc, ur);
		User hf=new User();
		hf=this.userservice.userbyname(uc.getUsername());
		
		Patient pat=new Patient();
		
		pat.setPid(hf.getId());
		pat.setName(uc.getUsername());
		
		
		
		
		
		return this.patser.savepat(pat);
		
		
	}
	
	@PostMapping("/createuseradm")
	public User usercreateadm(@RequestBody User uc) throws Exception {
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(44L);
		r.setRolename("ADMIN");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		
		return this.userservice.createuser(uc, ur);
		
		
	}
	
	@GetMapping("/{id}")
	public User userbyid(@PathVariable("id") Long id) {
		return this.userservice.userbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable("id") Long id) {
		this.userservice.userdeletebyid(id);
		
	}
	
	@PutMapping("/update")
	public User updateuser(@RequestBody User update) {
		return this.userservice.updateuser(update);
	}
	
	@GetMapping("/showall")
	public Set<User> showall(){
		return this.userservice.alluser();
	}
	
	
	
	
	

}
