package com.hospital.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dto.PageResponse;
import com.hospital.Dto.PatientReqDto;
import com.hospital.Dto.PatientResDto;

@Service
public interface PatientService {

	boolean addPatient(PatientReqDto patientsReqDto);

	PatientResDto patientById(int id);

	boolean updatePatient(PatientReqDto patientsReqDto);

	PageResponse<PatientResDto> findInactivePatientByUserId(int userId, Pageable pageable);

	List<PatientResDto> searchPatientByNameAndUserId(String name, String status, int userId);

	PageResponse<PatientResDto> findAllPatients(Pageable pageable);

	PageResponse<PatientResDto> findPatientsByuserId(int userId, Pageable pageable);

	List<PatientResDto> searchAllPatientByName(String name, String status);

	PageResponse<PatientResDto> findAllInActivePatient(Pageable pageable);

	long getPatientsCount();

}
