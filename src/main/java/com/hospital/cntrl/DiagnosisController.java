package com.hospital.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Dto.DiagnosisReqDto;
import com.hospital.Dto.DiagnosisResDto;
import com.hospital.Dto.PageResponse;
import com.hospital.service.DiagnosisService;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

	@Autowired
	private DiagnosisService diagnosisService;

	@PostMapping("/add")
	public boolean addDiagnosis(@RequestBody DiagnosisReqDto dto) {
		return diagnosisService.addDiagnosis(dto);
	}

	@GetMapping("/all/{userId}/{page}/{size}")
	public PageResponse<DiagnosisResDto> getDiagnosisByUserId(@PathVariable int page, @PathVariable int size,
			@PathVariable int userId) {
		System.out.println(userId);
		Pageable pageable = PageRequest.of(page, size);
		return diagnosisService.getDiagnosisByUserId(pageable, userId);
	}

	@GetMapping("/searchbyName/{name}")
	public List<DiagnosisResDto> searchDiagnosisByName(@PathVariable String name) {
		return diagnosisService.searchDiagnosisByName(name);
	}

	@PostMapping("/update")
	public boolean updateDiagnosis(@RequestBody DiagnosisReqDto dto) {
		return diagnosisService.updateDiagnosis(dto);
	}

	@GetMapping("/By-PatientId/{patientId}")
	public List<DiagnosisResDto> getDiagnosisByPatientId(@PathVariable int patientId) {
		List<DiagnosisResDto> DiagnosisList = diagnosisService.getDiagnosisByPatientId(patientId);
		return DiagnosisList;
	}
}