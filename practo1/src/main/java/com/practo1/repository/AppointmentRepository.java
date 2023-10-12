package com.practo1.repository;

import com.practo1.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appoinment,Integer> {
    List<Appoinment> findByAppointmentDateAndAppointmentTime(LocalDate appointmentDate, LocalTime appointmentTime);

}
