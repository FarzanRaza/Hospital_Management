package com.practo1.service;

import com.practo1.entity.Patient;
import com.practo1.repository.DoctorRepository;
import com.practo1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
        private PatientRepository repoo;
    @Override
    public Patient savePatient(Patient patient) {
        return repoo.save(patient);
    }
}
