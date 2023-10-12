package com.practo1.controller;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import com.practo1.payload.DoctorDto;
import com.practo1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @PostMapping("/doctor")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        Doctor doctorDto1 = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(doctorDto1, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public List<Doctor> searchDoctors(@RequestParam String searchTerm) {
        return doctorService.searchDoctors(searchTerm);
    }

}
