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

import com.hospital.Dto.PageResponse;
import com.hospital.Dto.PatientReqDto;
import com.hospital.Dto.PatientResDto;
import com.hospital.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientService patientService;

	@PostMapping("/add")
	public boolean addPatient(@RequestBody PatientReqDto patientsReqDto) {
		System.out.println(patientsReqDto.getUserId());
		boolean isAdded = patientService.addPatient(patientsReqDto);
		return isAdded;
	}

	@GetMapping("/active/{userId}/{page}/{size}")
	public PageResponse<PatientResDto> findByUserId(@PathVariable int userId, @PathVariable int page,
			@PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return patientService.findPatientsByuserId(userId, pageable);
	}

	@GetMapping("/getInactiveRecord/{userId}")
	public List<PatientResDto> findInactivePatientByUserId(@PathVariable int userId) {
		System.out.println("the id is:" + userId);
		List<PatientResDto> list = patientService.findInactivePatientByUserId(userId);
		return list;
	}

	@GetMapping("/getpatientById/{id}")
	public PatientResDto patientById(@PathVariable int id) {
		PatientResDto patientResDto = patientService.patientById(id);
		System.out.println(patientResDto.getAddress());
		return patientResDto;
	}

	@PostMapping("/updatepatientRecord")
	public boolean updatePatient(@RequestBody PatientReqDto patientsReqDto) {
		boolean isAdded = patientService.updatePatient(patientsReqDto);
		return isAdded;
	}

	@GetMapping("/searchbyName/{name}/{status}/{userId}")
	public List<PatientResDto> searchPatientByNameAndUserId(@PathVariable String name, @PathVariable String status,
			@PathVariable int userId) {
		return patientService.searchPatientByNameAndUserId(name, status, userId);
	}

	@GetMapping("/all/{page}/{size}")
	public PageResponse<PatientResDto> findAllPatients(@PathVariable int page, @PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return patientService.findAllPatients(pageable);
	}

	// admin search all patients
	@GetMapping("/all/searchbyName/{name}/{status}")
	public List<PatientResDto> searchAllPatientByName(@PathVariable String name, @PathVariable String status) {
		return patientService.searchAllPatientByName(name, status);
	}

	@GetMapping("/all/Inactive-patient/{page}/{size}")
	public PageResponse<PatientResDto> findAllInActivePatient(@PathVariable int page, @PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return patientService.findAllInActivePatient(pageable);
	}
}
