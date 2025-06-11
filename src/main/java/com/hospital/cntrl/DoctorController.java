package com.hospital.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println(doctorDto.getPhone());
		System.out.println(doctorDto.getFirstName());
		boolean isAdded = doctorService.saveDoctor(doctorDto);

		return "doctor added sucessfully";
	}

	@GetMapping("/getallRecord")
	public List<DoctorResponseDto> getAllDoctor() {
		List<DoctorResponseDto> doctorList = doctorService.getAllDoctor();
		return doctorList;
	}

	@PostMapping("/updateRecord")
	public String updateDoctor(@RequestBody DoctorRequestDto doctorDto) {
		System.out.println(doctorDto.getFirstName());
		doctorService.updateDoctor(doctorDto);
		return "doctor updated sucessfull";
	}

}
