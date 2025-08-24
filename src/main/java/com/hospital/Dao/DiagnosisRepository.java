package com.hospital.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.entity.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

	List<Diagnosis> findByPatientNameContainingIgnoreCase(String name);

	List<Diagnosis> findByPatientId(int patientId);

	@Modifying
	@Transactional
	@Query("UPDATE Diagnosis d SET d.status = :status WHERE d.patient.id = :patientId")
	void updateDiagnosisByPatientId(@Param("patientId") int patientId, @Param("status") String status);

	Page<Diagnosis> findByUserIdAndStatus(Pageable pageable, int userId, String string);

}
