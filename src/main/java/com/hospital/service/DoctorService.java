package com.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.Dto.DoctorRequestDto;
import com.hospital.Dto.DoctorResponseDto;

@Service
public interface DoctorService {

	boolean saveDoctor(DoctorRequestDto doctorDto);

	List<DoctorResponseDto> getAllDoctor(int userId);

	List<DoctorResponseDto> getAllDoctor();

	boolean updateDoctor(DoctorRequestDto doctorDto);

	DoctorResponseDto findByEmail(String email);

	long getDoctorCount();

	DoctorResponseDto DoctorById(int id);

}
