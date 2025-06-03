package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.Dto.DoctorRequestDto;
import com.hospital.entity.Doctor;

@Component
public class DoctorMapper {
	public Doctor toEntity(DoctorRequestDto dto) {
		Doctor doctor = new Doctor(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getPhone(), dto.getEmail(),
				dto.getDepartment(), dto.getSpeciality(), dto.getFromTime(), dto.getToTime());
		return doctor;
	}

}
