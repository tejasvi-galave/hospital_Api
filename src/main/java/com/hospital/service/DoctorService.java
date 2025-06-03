package com.hospital.service;

import org.springframework.stereotype.Service;

import com.hospital.Dto.DoctorRequestDto;

@Service
public interface DoctorService {

	boolean saveDoctor(DoctorRequestDto doctorDto);

}
