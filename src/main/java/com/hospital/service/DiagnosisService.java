package com.hospital.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dto.DiagnosisReqDto;
import com.hospital.Dto.DiagnosisResDto;
import com.hospital.Dto.PageResponse;

@Service
public interface DiagnosisService {

	boolean addDiagnosis(DiagnosisReqDto dto);

	PageResponse<DiagnosisResDto> getDiagnosisByUserId(Pageable pageable, int userId);

	List<DiagnosisResDto> searchDiagnosisByName(String name);

	boolean updateDiagnosis(DiagnosisReqDto dto);

	List<DiagnosisResDto> getDiagnosisByPatientId(int patientId);

}
