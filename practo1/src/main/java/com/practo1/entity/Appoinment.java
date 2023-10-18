package com.practo1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appoinment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int doctorId;
    private int patientId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    // New field
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctors_id", nullable = false)
    private Doctor doctor;

}
