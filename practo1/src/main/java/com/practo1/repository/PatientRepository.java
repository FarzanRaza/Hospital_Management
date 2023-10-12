package com.practo1.repository;

import com.practo1.entity.Doctor;
import com.practo1.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    public Patient findByPatientId(int patientId);
}
