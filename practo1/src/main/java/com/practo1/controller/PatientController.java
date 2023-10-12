package com.practo1.controller;

import com.practo1.entity.Patient;
import com.practo1.payload.DoctorDto;
import com.practo1.service.DoctorService;
import com.practo1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    public ResponseEntity<Patient> saveDoctor(@RequestBody Patient patient){
        Patient patient1 = patientService.savePatient(patient);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }
}
