package com.practo1.service;

import com.practo1.entity.*;
import com.practo1.exception.DoctorNotFoundException;
import com.practo1.exception.PatientNotFoundException;
import com.practo1.repository.AppointmentRepository;
import com.practo1.repository.DoctorRepository;
import com.practo1.repository.PatientRepository;
import com.practo1.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppoinmentService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public String bookAppointment(Appoinment appointment) {
        Doctor byDoctorId = doctorRepository.findByDoctorId(appointment.getDoctorId());
        Patient byPatientId = patientRepository.findByPatientId(appointment.getPatientId());
        if (byDoctorId!=null && byPatientId!=null) {
            if (isSlotAvailable(appointment.getAppointmentDate(), appointment.getAppointmentTime())) {

                appointmentRepository.save(appointment);
                emailService.sendAppointmentConfirmationEmail(byPatientId, appointment);
                return "Appointment booked successfully.";

            } else {
                return "Slot is already booked for the selected date and time.";
            }
        } else {
            // Handle the case where either doctor or patient is not found
            if (byDoctorId==null) {
                throw new DoctorNotFoundException("Doctor not found with ID: " + appointment.getDoctorId());
            } else {
                throw new PatientNotFoundException("Patient not found with ID: " + appointment.getPatientId());
            }
        }
    }
    public boolean isSlotAvailable(LocalDate appointmentDate, LocalTime appointmentTime) {
        // Query the database to check for existing appointments with the same date and time
            List<Appoinment> existingAppointments = appointmentRepository.findByAppointmentDateAndAppointmentTime(appointmentDate, appointmentTime);
        // If there are no existing appointments for the same date and time, the slot is available
            return existingAppointments.isEmpty();
    }




}
