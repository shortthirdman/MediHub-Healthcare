package com.shortthirdman.medihub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "medical_record_details", schema = "public")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String diagnosis;
    private String treatment;
    private LocalDate treatmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
