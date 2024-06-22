package com.shortthirdman.medihub.controller;

import com.shortthirdman.medihub.domain.Appointment;
import com.shortthirdman.medihub.model.request.AppointmentDto;
import com.shortthirdman.medihub.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = {"*"})
@RequestMapping(value = "/appointments")
public class AppointmentsController extends AbstractBaseController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment scheduleAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.scheduleAppointment(appointmentDto);
    }

    @PutMapping("/{appointmentId}/reschedule")
    public Appointment rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody AppointmentDto updatedAppointment) {
        return appointmentService.rescheduleAppointment(appointmentId, updatedAppointment);
    }

    @PutMapping("/{appointmentId}/cancel")
    public Appointment cancelAppointment(@PathVariable Long appointmentId) {
        return appointmentService.cancelAppointment(appointmentId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsForPatient(patientId);
    }
}
