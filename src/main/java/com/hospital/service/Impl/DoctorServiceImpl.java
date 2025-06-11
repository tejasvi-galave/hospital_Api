package com.hospital.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.DoctorRepository;
import com.hospital.Dao.LoginRepository;
import com.hospital.Dto.DoctorRequestDto;
import com.hospital.Dto.DoctorResponseDto;
import com.hospital.entity.Doctor;
import com.hospital.entity.Login;
import com.hospital.mapper.DoctorMapper;
import com.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	LoginRepository loginRepository;

	@Override
	public boolean saveDoctor(DoctorRequestDto doctorDto) {
		Doctor doctor = doctorMapper.toEntity(doctorDto);
		try {
			Doctor addedLogin = doctorRepository.save(doctor);
			Login login = new Login();
			login.setUsername(addedLogin.getEmail());
			login.setPassword("demo");
			login.setRole("doctor");
			loginRepository.save(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<DoctorResponseDto> getAllDoctor() {
		Iterable<Doctor> allDoctors = doctorRepository.findAll();
		List<DoctorResponseDto> toList = new ArrayList<DoctorResponseDto>();
		for (Doctor doctor : allDoctors) {
			DoctorResponseDto doctorResDto = doctorMapper.toDto(doctor);
			toList.add(doctorResDto);
		}
		return toList;
	}

	@Override
	public boolean updateDoctor(DoctorRequestDto doctorDto) {
		Doctor doctor = doctorMapper.toEntity(doctorDto);
		try {
			Doctor addedLogin = doctorRepository.save(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
