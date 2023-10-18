package com.practo1.controller;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import com.practo1.payload.DoctorDto;
import com.practo1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/doctor")
    public ResponseEntity<?> saveDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Doctor doctorDto1 = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(doctorDto1, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/search")
    public List<Doctor> searchDoctors(@Valid @RequestParam String searchTerm) {

        return doctorService.searchDoctors(searchTerm);
    }


}
