package com.hospital.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.DoctorRepository;
import com.hospital.Dto.DoctorRequestDto;
import com.hospital.entity.Doctor;
import com.hospital.mapper.DoctorMapper;
import com.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorMapper doctorMapper;

	@Override
	public boolean saveDoctor(DoctorRequestDto doctorDto) {
		Doctor doctor = doctorMapper.toEntity(doctorDto);
		try {
			doctorRepository.save(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
