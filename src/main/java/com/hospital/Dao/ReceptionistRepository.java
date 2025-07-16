package com.hospital.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Receptionist;

@Repository
public interface ReceptionistRepository extends CrudRepository<Receptionist, Integer> {

	Optional<Receptionist> findByEmail(String email);

}
