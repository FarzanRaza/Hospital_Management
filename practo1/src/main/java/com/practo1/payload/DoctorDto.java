package com.practo1.payload;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDto {
    private Doctor doctor;
    private List<Review> reviews;
}

