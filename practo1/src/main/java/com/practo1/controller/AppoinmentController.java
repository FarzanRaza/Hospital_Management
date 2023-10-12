package com.practo1.controller;

import com.practo1.entity.Appoinment;
import com.practo1.service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppoinmentController {
    @Autowired
    private AppoinmentService appoinmentService;
    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody Appoinment appointment) {
        String response = appoinmentService.bookAppointment(appointment);
        return ResponseEntity.ok(response);
    }
}





