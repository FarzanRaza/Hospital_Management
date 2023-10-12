package com.practo1.repository;

import com.practo1.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
   List<Review> findAllByDoctorId(int doctorId);
}
