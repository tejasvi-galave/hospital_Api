package com.hospital.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public boolean saveDoctor(DoctorRequestDto doctorDto) {
		Doctor doctor = doctorMapper.toEntity(doctorDto);
		try {

			doctorRepository.save(doctor);

			Login login = new Login();
			login.setUsername(doctor.getEmail());
			login.setPassword("demo");
			login.setRole("doctor");
			loginRepository.save(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
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
		try {

			Optional<Doctor> existingOpt = doctorRepository.findById(doctorDto.getId());

			if (existingOpt.isEmpty()) {
				return false;
			}

			Doctor existingDoctor = existingOpt.get();
			String oldEmail = existingDoctor.getEmail();

			Doctor updatedDoctor = doctorMapper.toEntity(doctorDto);
			Doctor savedDoctor = doctorRepository.save(updatedDoctor);

			if (!oldEmail.equals(savedDoctor.getEmail())) {
				Optional<Login> loginOpt = loginRepository.findByUsername(oldEmail);
				if (loginOpt.isPresent()) {
					Login login = loginOpt.get();
					login.setUsername(savedDoctor.getEmail());
					loginRepository.save(login);
				}
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
