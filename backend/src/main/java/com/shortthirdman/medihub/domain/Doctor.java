package com.shortthirdman.medihub.domain;

import com.shortthirdman.medihub.common.enums.Specialization;
import com.shortthirdman.medihub.common.exception.DoctorNotAvailableException;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctor_details", schema = "public")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    private int yearsOfExperience;
    private String contactInformation;
    private String workingHours;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    public boolean isAvailable(LocalDateTime dateTime) {
        // Check if the doctor is available at the given dateTime.
        // In this example, we'll just check if the doctor has any appointments that overlap with the given dateTime.
        // In a real application, you would probably need to check the doctor's working hours and other factors.

        for (Appointment appointment : appointments) {
            LocalDateTime appointmentTime = appointment.getAppointmentTime();

            // If the doctor has an appointment that starts less than an hour after the given dateTime,
            // or that ends less than an hour before the given dateTime, then the doctor is not available.
            if ((appointmentTime.isAfter(dateTime) && appointmentTime.isBefore(dateTime.plusHours(1))) ||
                    (appointmentTime.plusHours(1).isAfter(dateTime) && appointmentTime.isBefore(dateTime))) {
                return true;  // Doctor is available
            }
        }

        // If we've checked all the doctor's appointments and found no conflicts, then the doctor is available.
        return false;  // Doctor is unavailable
    }

    public Appointment scheduleAppointment(Patient patient, LocalDateTime dateTime) {
        if (!isAvailable(dateTime)) {
            throw new DoctorNotAvailableException("Doctor with id " + this.getId() + " is not available at the requested time");
        }
        Appointment appointment = new Appointment();
        appointment.setDoctor(this);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(dateTime);
        appointment.setStatus("Scheduled");
        appointments.add(appointment);
        return appointment;
    }
}
