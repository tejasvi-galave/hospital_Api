package com.hospital.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	@Query("SELECT d.id FROM Doctor d")
	List<Integer> findAllDoctorIds();

	Optional<Doctor> findByEmail(String email);

	Iterable<Doctor> findByUserIdAndStatus(int userId, String status);

	Iterable<Doctor> findByStatus(String status);

}
