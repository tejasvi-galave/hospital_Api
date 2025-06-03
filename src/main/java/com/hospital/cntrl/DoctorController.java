package com.hospital.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Dto.DoctorRequestDto;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@PostMapping("/add")
	public boolean saveDoctor(@RequestBody DoctorRequestDto doctorDto) {
		System.out.println(doctorDto.getPhone());
		System.out.println(doctorDto.getFirstName());
		boolean isAdded = doctorService.saveDoctor(doctorDto);
		return isAdded;
	}
}
