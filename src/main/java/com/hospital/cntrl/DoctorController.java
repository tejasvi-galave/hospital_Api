package com.hospital.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Dto.DoctorRequestDto;
import com.hospital.Dto.DoctorResponseDto;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@PostMapping("/add")
	public String saveDoctor(@RequestBody DoctorRequestDto doctorDto) {
		boolean isAdded = doctorService.saveDoctor(doctorDto);

		return "doctor added sucessfully";
	}

	@GetMapping("/getallRecord/{userId}")
	public List<DoctorResponseDto> getAllDoctor(@PathVariable int userId) {
		System.out.println(userId);
		List<DoctorResponseDto> doctorList = doctorService.getAllDoctor(userId);
		return doctorList;
	}

	@PostMapping("/update")
	public boolean updateDoctor(@RequestBody DoctorRequestDto doctorDto) {
		boolean isAdded = doctorService.updateDoctor(doctorDto);
		return isAdded;
	}

	@GetMapping("/byEmail")
	public DoctorResponseDto getDoctorByEmail(@RequestParam String email) {
		return doctorService.findByEmail(email);
	}

	@GetMapping("/count")
	public long getDoctorCount() {
		return doctorService.getDoctorCount();
	}

	@GetMapping("/getDoctorById/{id}")
	public DoctorResponseDto DoctorById(@PathVariable int id) {
		DoctorResponseDto doctorResDto = doctorService.DoctorById(id);

		return doctorResDto;
	}
}
