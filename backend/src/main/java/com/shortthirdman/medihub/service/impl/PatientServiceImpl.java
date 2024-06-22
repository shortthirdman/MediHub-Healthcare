package com.shortthirdman.medihub.service.impl;

import com.shortthirdman.medihub.common.exception.InvalidAddressException;
import com.shortthirdman.medihub.common.exception.PatientNotFoundException;
import com.shortthirdman.medihub.domain.Address;
import com.shortthirdman.medihub.domain.MedicalRecord;
import com.shortthirdman.medihub.domain.Patient;
import com.shortthirdman.medihub.repository.PatientsRepository;
import com.shortthirdman.medihub.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientsRepository patientsRepository;

    @Override
    public Patient registerPatient(Patient patient) {
        return patientsRepository.save(patient);
    }

    @Override
    public Patient updateAddress(Long id, Address newAddress) {
        Patient patient = patientsRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + " not found"));
        if (!newAddress.isValid()) {
            throw new InvalidAddressException("Invalid address");
        }
        patient.updateAddress(newAddress);
        return patientsRepository.save(patient);
    }

    @Override
    public Patient updateMedicalHistory(Long id, MedicalRecord newRecord) {
        Patient patient = patientsRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + " not found"));
        patient.updateMedicalHistory(newRecord);
        return patientsRepository.save(patient);
    }
}
