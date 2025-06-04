package com.hospital.service.Impl;

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
		System.out.println(login.getUserName());
		System.out.println(loginRequestDto.getUserName());
		System.out.println(loginRequestDto.getPassword());
		// get data in db
		Login existingUser = loginRepository.findByLoginDetails(loginRequestDto.getUserName(),
				loginRequestDto.getPassword());
		System.out.println(existingUser.getPassword() + " " + existingUser.getRole());
		if (existingUser != null) {
			// that entity data conver into response dto in using login mapper class and
			// then return response
			LoginResponseDto responseDto = loginMapper.toResponseDto(existingUser.getUserName(),
					existingUser.getRole());

			return responseDto;
		} else {
			return null;
		}

	}
}
