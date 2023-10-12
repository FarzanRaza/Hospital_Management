package com.practo1.repository;

import com.practo1.entity.Doctor;
import com.practo1.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorId(int doctorId);
    @Query("SELECT d FROM Doctor d WHERE d.name LIKE %:searchTerm% OR d.specialization LIKE %:searchTerm% OR d.hospitalName LIKE %:searchTerm%")
    List<Doctor> searchDoctors(@Param("searchTerm") String searchTerm);
}
