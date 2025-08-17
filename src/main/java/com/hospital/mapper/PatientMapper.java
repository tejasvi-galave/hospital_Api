package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.Dto.PatientReqDto;
import com.hospital.Dto.PatientResDto;
import com.hospital.entity.Patient;

@Component
public class PatientMapper {

	public Patient toEntity(PatientReqDto patientsReqDto) {
		return new Patient(patientsReqDto.getId(), patientsReqDto.getName(), patientsReqDto.getAge(),
				patientsReqDto.getGender(), patientsReqDto.getPhone(), patientsReqDto.getBloodGroup(),
				patientsReqDto.getAddress(), patientsReqDto.getMedicalHistory(), patientsReqDto.getUserId(),
				patientsReqDto.getStatus());
	}

	public PatientResDto toDto(Patient patient) {
		PatientResDto dto = new PatientResDto();
		dto.setId(patient.getId());
		dto.setName(patient.getName());
		dto.setAge(patient.getAge());
		dto.setGender(patient.getGender());
		dto.setPhone(patient.getPhone());
		dto.setBloodGroup(patient.getBloodGroup());
		dto.setAddress(patient.getAddress());
		dto.setMedicalHistory(patient.getMedicalHistory());
		dto.setStatus(patient.getStatus());
		return dto;
	}

}
