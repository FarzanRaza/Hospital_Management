package com.practo1.service;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import com.practo1.payload.DoctorDto;

import java.util.List;

public interface DoctorService {
    public Doctor saveDoctor(Doctor doctor);


    Doctor findRecordById(int doctorId);

    List<Doctor> searchDoctors(String searchTerm);
}
