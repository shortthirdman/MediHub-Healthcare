package com.shortthirdman.medihub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointment_details", schema = "public")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private LocalDateTime appointmentTime;

    private String status;

    public boolean reschedule(LocalDateTime newAppointmentTime) {
        if (doctor.isAvailable(newAppointmentTime)) {
            return false;
        }
        this.appointmentTime = newAppointmentTime;
        return true;
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public boolean isWithDoctor(Doctor doctor) {
        return this.doctor.equals(doctor);
    }

    public boolean isWithPatient(Patient patient) {
        return this.patient.equals(patient);
    }
}
