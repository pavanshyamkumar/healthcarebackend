package com.project.HealthCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.HealthCare.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long> {

}
