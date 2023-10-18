package com.practo1.utils;

import com.practo1.entity.Appoinment;
import com.practo1.entity.Patient;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAppointmentConfirmationEmail(Patient patient, Appoinment appointment) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setFrom("farzanraza99@gmail.com");
            helper.setTo(patient.getEmail());
            helper.setSubject("Appointment Confirmation");

            String body = "Dear " + patient.getPatientName() + ",\n\n" +
                    "This email is to confirm your appointment with Dr. " + appointment.getDoctor().getName() + " on " + appointment.getAppointmentDate() + " at " + appointment.getAppointmentTime() + ".\n\n" +
                    "Please arrive 15 minutes early to your appointment to complete any necessary paperwork.\n\n" +
                    "If you have any questions or need to cancel your appointment, please call our office at (123) 456-7890.\n\n" +
                    "Thank you for choosing our practice.\n\n" +
                    "Sincerely,\n" +
                    "The Practo Team";

            helper.setText(body, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

