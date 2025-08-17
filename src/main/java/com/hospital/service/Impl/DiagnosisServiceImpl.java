package com.hospital.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dao.DiagnosisRepository;
import com.hospital.Dto.DiagnosisReqDto;
import com.hospital.Dto.DiagnosisResDto;
import com.hospital.Dto.PageResponse;
import com.hospital.entity.Diagnosis;
import com.hospital.mapper.DiagnosisMapper;
import com.hospital.service.DiagnosisService;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	DiagnosisRepository diagnosisRepository;
	@Autowired
	DiagnosisMapper diagnosisMapper;

	@Override
	public boolean addDiagnosis(DiagnosisReqDto dto) {
		try {
			Diagnosis diagnosis = diagnosisMapper.dtoEntity(dto);
			diagnosis.setStatus("Active");
			diagnosisRepository.save(diagnosis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public PageResponse<DiagnosisResDto> getDiagnosisByUserId(Pageable pageable, int userId) {
		Page<Diagnosis> diagnosisList = diagnosisRepository.findByStatus(pageable, userId, "Active");
		List<DiagnosisResDto> dtoList = diagnosisList.stream().map(diagnosis -> diagnosisMapper.toDto(diagnosis))
				.collect(Collectors.toList());
		PageResponse<DiagnosisResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(diagnosisList.getNumber());
		response.setPageSize(diagnosisList.getSize());
		response.setTotalPages(diagnosisList.getTotalPages());
		response.setTotalElements(diagnosisList.getTotalElements());

		return response;
	}

	@Override
	public List<DiagnosisResDto> searchDiagnosisByName(String name) {
		List<Diagnosis> diagnosisList = diagnosisRepository.findByPatientNameContainingIgnoreCase(name);

		List<DiagnosisResDto> dtoList = diagnosisList.stream().map(diagnosis -> diagnosisMapper.toDto(diagnosis))
				.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public boolean updateDiagnosis(DiagnosisReqDto dto) {
		try {
			Diagnosis diagnosis = diagnosisMapper.dtoEntity(dto);
			diagnosisRepository.save(diagnosis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<DiagnosisResDto> getDiagnosisByPatientId(int patientId) {
		List<Diagnosis> diagnosisList = diagnosisRepository.findByPatientId(patientId);

		List<DiagnosisResDto> dtoList = diagnosisList.stream().map(diagnosis -> diagnosisMapper.toDto(diagnosis))
				.collect(Collectors.toList());
		return dtoList;
	}

}
