package com.hospital.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.LoginRepository;
import com.hospital.entity.Login;
import com.hospital.loginDto.LoginRequestDto;
import com.hospital.loginDto.LoginResponseDto;
import com.hospital.mapper.LoginMapper;
import com.hospital.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;

	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginResponseDto checkExistAccount(LoginRequestDto loginRequestDto) {
		// Log incoming data
		System.out.println(loginRequestDto.getUsername());
		System.out.println(loginRequestDto.getPassword());

		// Check if user exists in DB
		Optional<Login> opt = loginRepository.findByLoginDetails(loginRequestDto.getUsername(),
				loginRequestDto.getPassword());

		if (opt.isPresent()) {
			Login logedUser = opt.get();

			// Map entity to response DTO and return
			LoginResponseDto loginData = loginMapper.toResponseDto(logedUser.getId(), logedUser.getUsername(),
					logedUser.getRole());

			return loginData;
		} else {
			return null; // or throw custom exception
		}
	}
}
