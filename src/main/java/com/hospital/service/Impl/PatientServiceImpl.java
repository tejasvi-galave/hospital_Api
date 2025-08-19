package com.hospital.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dao.AppointmentRepository;
import com.hospital.Dao.DiagnosisRepository;
import com.hospital.Dao.PatientRepository;
import com.hospital.Dto.PageResponse;
import com.hospital.Dto.PatientReqDto;
import com.hospital.Dto.PatientResDto;
import com.hospital.entity.Patient;
import com.hospital.mapper.PatientMapper;
import com.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	PatientMapper patientMapper;

	@Autowired
	DiagnosisRepository diagnosisRepository;

	@Override
	public boolean addPatient(PatientReqDto patientsReqDto) {

		Patient patients = patientMapper.toEntity(patientsReqDto);
		patients.setStatus("Active");
		try {
			patientRepository.save(patients);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public PatientResDto patientById(int id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			Patient result = patient.get();
			PatientResDto patientDto = patientMapper.toDto(result);
			return patientDto;
		}
		return null;
	}

	@Override
	public boolean updatePatient(PatientReqDto patientsReqDto) {
		try {

			Patient patient = patientMapper.toEntity(patientsReqDto);

			Patient savedPatient = patientRepository.save(patient);

			if ("Inactive".equalsIgnoreCase(savedPatient.getStatus())) {
				appointmentRepository.updateAppointmentsByPatientId(savedPatient.getId(), "Inactive");
				diagnosisRepository.updateDiagnosisByPatientId(savedPatient.getId(), "Inactive");
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageResponse findInactivePatientByUserId(int userId, Pageable pageable) {
		Page<Patient> pageData = patientRepository.findByUserIdAndStatus(userId, "Inactive", pageable);
		List<PatientResDto> dtoList = new ArrayList<>();
		for (Patient p : pageData.getContent()) {
			dtoList.add(patientMapper.toDto(p));
		}
		PageResponse<PatientResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(pageData.getNumber());
		response.setPageSize(pageData.getSize());
		response.setTotalPages(pageData.getTotalPages());
		response.setTotalElements(pageData.getTotalElements());

		return response;
	}

	@Override
	public List<PatientResDto> searchPatientByNameAndUserId(String name, String status, int userId) {
		List<Patient> patients = patientRepository.findByNameContainingAndUserIdAndStatus(name, userId, status);
		List<PatientResDto> result = new ArrayList<>();

		for (Patient patient : patients) {
			PatientResDto dto = patientMapper.toDto(patient);
			result.add(dto);
		}

		return result;
	}

	@Override
	public PageResponse<PatientResDto> findAllPatients(Pageable pageable) {

		Page<Patient> pageData = patientRepository.findByStatus("active", pageable);

		List<PatientResDto> dtoList = pageData.getContent().stream().map(patient -> patientMapper.toDto(patient))
				.collect(Collectors.toList());

		PageResponse<PatientResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(pageData.getNumber());
		response.setPageSize(pageData.getSize());
		response.setTotalPages(pageData.getTotalPages());
		response.setTotalElements(pageData.getTotalElements());

		return response;
	}

	@Override
	public PageResponse<PatientResDto> findPatientsByuserId(int userId, Pageable pageable) {

		Page<Patient> pageData = patientRepository.findByUserIdAndStatus(userId, "active", pageable);

		List<PatientResDto> dtoList = new ArrayList<>();
		for (Patient p : pageData.getContent()) {
			dtoList.add(patientMapper.toDto(p));
		}

		PageResponse<PatientResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(pageData.getNumber());
		response.setPageSize(pageData.getSize());
		response.setTotalPages(pageData.getTotalPages());
		response.setTotalElements(pageData.getTotalElements());

		return response;
	}

	@Override
	public List<PatientResDto> searchAllPatientByName(String name, String status) {
		List<Patient> patients = patientRepository.findByNameContainingAndStatus(name, status);

		List<PatientResDto> result = patients.stream().map(patient -> patientMapper.toDto(patient))
				.collect(Collectors.toList());

		return result;

	}

	@Override
	public PageResponse<PatientResDto> findAllInActivePatient(Pageable pageable) {
		Page<Patient> pageData = patientRepository.findByStatus("Inactive", pageable);

		List<PatientResDto> dtoList = pageData.getContent().stream().map(patient -> patientMapper.toDto(patient))
				.collect(Collectors.toList());

		PageResponse<PatientResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(pageData.getNumber());
		response.setPageSize(pageData.getSize());
		response.setTotalPages(pageData.getTotalPages());
		response.setTotalElements(pageData.getTotalElements());

		return response;
	}

	@Override
	public long getPatientsCount() {
		return patientRepository.count();
	}

}
