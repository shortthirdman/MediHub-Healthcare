package com.shortthirdman.medihub.controller;

import com.shortthirdman.medihub.domain.Address;
import com.shortthirdman.medihub.domain.MedicalRecord;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = {"*"})
@RequestMapping(value = "/patients")
public class PatientsController extends AbstractBaseController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Patient> updateAddress(@PathVariable Long id, @RequestBody Address newAddress) {
        Patient updatedPatient = patientService.updateAddress(id, newAddress);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @PutMapping("/{id}/medicalHistory")
    public ResponseEntity<Patient> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalRecord newRecord) {
        Patient updatedPatient = patientService.updateMedicalHistory(id, newRecord);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }
}
