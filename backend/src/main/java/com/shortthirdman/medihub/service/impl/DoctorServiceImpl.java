package com.shortthirdman.medihub.service.impl;

import com.shortthirdman.medihub.common.RecaptchaServiceHelper;
import com.shortthirdman.medihub.common.exception.DoctorNotFoundException;
import com.shortthirdman.medihub.domain.Appointment;
import com.shortthirdman.medihub.domain.Doctor;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.model.request.DoctorDto;
import com.shortthirdman.medihub.repository.DoctorsRepository;
import com.shortthirdman.medihub.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorsRepository doctorsRepository;

    @Autowired
    RecaptchaServiceHelper recaptchaService;

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorsRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorsRepository.findById(id).orElseThrow(
                () -> new DoctorNotFoundException("Doctor with id " + id + " not found")
        );
    }

    @Override
    public DoctorDto getDoctor(Long id, String name, String date) {
        return convertToDto(getDoctorById(id));
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        return convertToDto(doctorsRepository.save(convertToEntity(doctorDto)));
    }

    @Override
    public DoctorDto updateDoctor(Long id, DoctorDto doctorDto) {
        Doctor existingDoctor = getDoctorById(id);
        existingDoctor.setName(doctorDto.getName());
        return convertToDto(doctorsRepository.save(existingDoctor));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorsRepository.deleteById(id);
    }

    @Override
    public DoctorDto scheduleAppointment(Long id, Patient patient, LocalDateTime dateTime) {
        Doctor doctor = getDoctorById(id);
        doctor.scheduleAppointment(patient, dateTime);
        return convertToDto(doctorsRepository.save(doctor));
    }

    @Override
    public String captcha(String recaptchaResponse) {
        return recaptchaService.isResponseValid(recaptchaResponse);
    }

    private DoctorDto convertToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setYearsOfExperience(doctor.getYearsOfExperience());
        doctorDto.setContactInformation(doctor.getContactInformation());
        doctorDto.setWorkingHours(doctor.getWorkingHours());
        doctorDto.setAppointmentIds(doctor.getAppointments().stream().map(Appointment::getId).collect(Collectors.toList()));
        return doctorDto;
    }

    private Doctor convertToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setYearsOfExperience(doctorDto.getYearsOfExperience());
        doctor.setContactInformation(doctorDto.getContactInformation());
        doctor.setWorkingHours(doctorDto.getWorkingHours());
        return doctor;
    }
}
