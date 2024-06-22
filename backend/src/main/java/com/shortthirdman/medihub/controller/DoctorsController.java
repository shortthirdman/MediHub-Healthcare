package com.shortthirdman.medihub.controller;

import com.shortthirdman.medihub.common.annotation.LogExecution;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.model.request.DoctorDto;
import com.shortthirdman.medihub.model.response.RecaptchaResponse;
import com.shortthirdman.medihub.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(value = {"*"})
@RequestMapping(value = "/doctors")
public class DoctorsController extends AbstractBaseController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    @LogExecution
    public List<DoctorDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/captcha")
    public String captcha(@RequestBody RecaptchaResponse recaptchaResponse) {
        return doctorService.captcha(recaptchaResponse.getRecaptchaResponse());
    }


    @GetMapping("/{id}")
    public DoctorDto getDoctor(@PathVariable Long id, @RequestParam String name, @RequestParam String date) {
        return doctorService.getDoctor(id, name, date);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDto createDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorService.createDoctor(doctorDto);
    }

    @PutMapping("/{id}")
    public DoctorDto updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        return doctorService.updateDoctor(id, doctorDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    @PostMapping("/{id}/schedule")
    public DoctorDto scheduleAppointment(@PathVariable Long id, @RequestBody Patient patient, LocalDateTime dateTime) {
        return doctorService.scheduleAppointment(id, patient, dateTime);
    }
}
