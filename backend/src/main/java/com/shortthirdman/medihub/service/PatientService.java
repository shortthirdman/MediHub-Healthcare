package com.shortthirdman.medihub.service;

import com.shortthirdman.medihub.domain.Address;
import com.shortthirdman.medihub.domain.MedicalRecord;
import com.shortthirdman.medihub.domain.Patient;

public interface PatientService {

    Patient registerPatient(Patient patient);

    Patient updateAddress(Long id, Address newAddress);

    Patient updateMedicalHistory(Long id, MedicalRecord newRecord);
}
