package com.hospital.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByUserIdAndStatus(int userId, String status);

	Page<Patient> findByStatus(String status, Pageable pageable);

	List<Patient> findByNameContainingAndUserIdAndStatus(String name, int userId, String status);

	Page<Patient> findByUserIdAndStatus(int userId, String status, Pageable pageable);

	List<Patient> findByNameContainingAndStatus(String name, String status);

}
