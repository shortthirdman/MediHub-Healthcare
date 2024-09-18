package com.shortthirdman.medihub.pharmacy.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PharmaceuticalDrug {

    private Integer drugId;
    private String drugName;
    private String genericName;
    private String dosage;
    private String form;
    private String activeIngredients;
    private String sideEffects;
    private Integer quantity;
    private String brandName;
}
