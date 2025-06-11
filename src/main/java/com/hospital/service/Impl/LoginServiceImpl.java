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
		// convert dto into login
		Login login = loginMapper.toEntity(loginRequestDto);
//		System.out.println(login.getUsername());
//		System.out.println(loginRequestDto.getUsername());
//		System.out.println(loginRequestDto.getPassword());
		// get data in db
		Optional<Login> opt = loginRepository.findByLoginDetails(loginRequestDto.getUsername(),
				loginRequestDto.getPassword());
//		System.out.println(existingUser.getPassword() + " " + existingUser.getRole());
		if (opt.isPresent()) {
			// that entity data conver into response dto in using login mapper class and
			// then return response
			Login logedUser = opt.get();
			LoginResponseDto loginData = loginMapper.toResponseDto(logedUser.getUsername(), logedUser.getRole());
			return loginData;
		}
		return null;

	}
}
