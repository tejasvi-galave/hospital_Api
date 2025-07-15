package com.hospital.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByUserIdAndStatus(int userId, String status); // inactive patient record

	Page<Patient> findByStatus(String status, Pageable pageable); // active all record & inactive

	List<Patient> findByNameContainingAndUserIdAndStatus(String name, int userId, String status);

	Page<Patient> findByUserIdAndStatus(int userId, String status, Pageable pageable); // active patient record by
																						// userid

	List<Patient> findByNameContainingAndStatus(String name, String status);

}
