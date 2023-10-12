package com.practo1.controller;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import com.practo1.payload.DoctorDto;
import com.practo1.service.DoctorService;
import com.practo1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/review")
    public ResponseEntity<Review> saveDoctor(@RequestBody Review review){
        return new ResponseEntity<>(reviewService.saveReview(review), HttpStatus.CREATED);
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> basedDoctorGetReview(@PathVariable int doctorId) {
        Doctor recordById = doctorService.findRecordById(doctorId);
        List<Review> reviews = reviewService.basedOnDoctorGetReview(doctorId);
        DoctorDto doctorDto=new DoctorDto(recordById,reviews);
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

}

