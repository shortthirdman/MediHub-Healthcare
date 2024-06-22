package com.shortthirdman.medihub.service;

import com.shortthirdman.medihub.domain.Appointment;
import com.shortthirdman.medihub.model.request.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    Appointment scheduleAppointment(AppointmentDto appointmentDto);

    Appointment rescheduleAppointment(Long appointmentId, AppointmentDto updatedAppointment);

    Appointment cancelAppointment(Long appointmentId);

    List<Appointment> getAppointmentsForPatient(Long patientId);
}
