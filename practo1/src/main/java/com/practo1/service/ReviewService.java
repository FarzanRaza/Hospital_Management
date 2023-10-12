package com.practo1.service;
import com.practo1.entity.Doctor;
import com.practo1.entity.Patient;
import com.practo1.entity.Review;
import com.practo1.exception.DoctorNotFoundException;
import com.practo1.exception.PatientNotFoundException;
import com.practo1.repository.DoctorRepository;
import com.practo1.repository.PatientRepository;
import com.practo1.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private  ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        // Check if the doctor and patient exist in the repositories

        Doctor byDoctorId = doctorRepository.findByDoctorId(review.getDoctorId());
        Patient byPatientId = patientRepository.findByPatientId(review.getPatientId());

        if (byDoctorId!=null && byPatientId!=null) {
            // Both doctor and patient exist, so save the review
            Review savedReview = reviewRepository.save(review);
            return savedReview;
        } else {
            // Handle the case where either doctor or patient is not found
            if (byDoctorId==null) {
                throw new DoctorNotFoundException("Doctor not found with ID: " + review.getDoctorId());
            } else {
                throw new PatientNotFoundException("Patient not found with ID: " + review.getPatientId());
            }
        }

    }





    public List<Review> basedOnDoctorGetReview(int doctorId) {
        return reviewRepository.findAllByDoctorId(doctorId);
    }

}
