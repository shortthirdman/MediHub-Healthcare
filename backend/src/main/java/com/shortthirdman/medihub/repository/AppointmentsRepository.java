package com.shortthirdman.medihub.repository;

import com.shortthirdman.medihub.domain.Appointment;
import com.shortthirdman.medihub.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatient(Patient patient);
}
