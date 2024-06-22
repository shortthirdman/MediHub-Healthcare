package com.shortthirdman.medihub.repository;

import com.shortthirdman.medihub.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
