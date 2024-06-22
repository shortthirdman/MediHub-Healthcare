package com.shortthirdman.medihub.service;

import com.shortthirdman.medihub.domain.Doctor;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.model.request.DoctorDto;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorService {

    List<DoctorDto> getAllDoctors();

    Doctor getDoctorById(Long id);

    DoctorDto getDoctor(Long id, String name, String date);

    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto updateDoctor(Long id, DoctorDto doctorDto);

    void deleteDoctor(Long id);

    DoctorDto scheduleAppointment(Long id, Patient patient, LocalDateTime dateTime);

    String captcha(String recaptchaResponse);
}
