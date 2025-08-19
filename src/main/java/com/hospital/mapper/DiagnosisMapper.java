package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.Dto.DiagnosisReqDto;
import com.hospital.Dto.DiagnosisResDto;
import com.hospital.entity.Diagnosis;
import com.hospital.entity.Patient;

@Component
public class DiagnosisMapper {

	public Diagnosis dtoEntity(DiagnosisReqDto dto) {
		Patient patient = new Patient();
		patient.setId(dto.getPatientId());

		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setDiagnosisId(dto.getDiagnosisId());
		diagnosis.setPatient(patient);
		diagnosis.setVisitDate(dto.getVisitDate());
		diagnosis.setDiagnosis(dto.getDiagnosis());
		diagnosis.setTreatment(dto.getTreatment());
		diagnosis.setPrescription(dto.getPrescription());
		diagnosis.setUserId(dto.getUserId());
		diagnosis.setStatus(dto.getStatus());
		return diagnosis;
	}

	public DiagnosisResDto toDto(Diagnosis diagnosis) {
		DiagnosisResDto dto = new DiagnosisResDto();
		dto.setDiagnosisId(diagnosis.getDiagnosisId());
		dto.setPatientId(diagnosis.getPatient().getId());
		dto.setPatientName(diagnosis.getPatient().getName());
		dto.setVisitDate(diagnosis.getVisitDate());
		dto.setDiagnosis(diagnosis.getDiagnosis());
		dto.setTreatment(diagnosis.getTreatment());
		dto.setPrescription(diagnosis.getPrescription());
		return dto;
	}
}
