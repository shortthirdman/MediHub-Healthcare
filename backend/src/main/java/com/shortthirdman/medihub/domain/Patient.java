package com.shortthirdman.medihub.domain;

import com.shortthirdman.medihub.common.exception.InvalidAddressException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "patient_details", schema = "public")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void updateAddress(Address newAddress) {
        if (newAddress.isValid()) {
            this.address = newAddress;
        } else {
            throw new InvalidAddressException("Invalid address");
        }
    }

    public void updateMedicalHistory(MedicalRecord newRecord) {
        this.medicalRecords.add(newRecord);
    }
}
