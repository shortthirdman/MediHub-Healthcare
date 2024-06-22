package com.shortthirdman.medihub.service.impl;

import com.shortthirdman.medihub.common.exception.AppointmentNotFoundException;
import com.shortthirdman.medihub.common.exception.DoctorNotFoundException;
import com.shortthirdman.medihub.common.exception.PatientNotFoundException;
import com.shortthirdman.medihub.domain.Appointment;
import com.shortthirdman.medihub.domain.Doctor;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.model.request.AppointmentDto;
import com.shortthirdman.medihub.repository.AppointmentsRepository;
import com.shortthirdman.medihub.repository.DoctorsRepository;
import com.shortthirdman.medihub.repository.PatientsRepository;
import com.shortthirdman.medihub.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentsRepository appointmentsRepository;

    @Autowired
    DoctorsRepository doctorRepository;

    @Autowired
    PatientsRepository patientRepository;

    @Override
    public Appointment scheduleAppointment(AppointmentDto appointmentDto) {
        Doctor doctor = doctorRepository
                .findById(appointmentDto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with id " + appointmentDto.getDoctorId() + " not found"));

        Patient patient = patientRepository.findById(appointmentDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + appointmentDto.getPatientId() + " not found"));

        Appointment appointment = doctor.scheduleAppointment(patient, appointmentDto.getAppointmentTime());

        return appointmentsRepository.save(appointment);
    }

    @Override
    public Appointment rescheduleAppointment(Long appointmentId, AppointmentDto updatedAppointment) {
        Appointment appointmentById = appointmentsRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + appointmentId + " not found"));

        log.info("Check if the doctor is available at the new time...");
        Doctor doctor = appointmentById.getDoctor();
        Patient patient = patientRepository.findById(updatedAppointment.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + updatedAppointment.getPatientId() + " not found"));
        Appointment appointment = doctor.scheduleAppointment(patient, updatedAppointment.getAppointmentTime());

        return appointmentsRepository.save(appointment);
    }

    @Override
    public Appointment cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentsRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + appointmentId + " not found"));

        log.info("Update the appointment status to \"Cancelled\" and saving the appointment");
        appointment.setStatus("Cancelled");
        return appointmentsRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + patientId + " not found"));

        // Fetch and return all appointments for the given patient
        return appointmentsRepository.findByPatient(patient);
    }
}
