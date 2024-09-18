package com.shortthirdman.medihub.pharmacy.repository;

import com.shortthirdman.medihub.pharmacy.entity.PharmaceuticalDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsInventoryRepository extends JpaRepository<PharmaceuticalDrug, Integer> {
}
