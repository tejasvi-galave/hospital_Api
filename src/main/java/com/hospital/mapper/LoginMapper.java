package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.entity.Login;
import com.hospital.loginDto.LoginRequestDto;
import com.hospital.loginDto.LoginResponseDto;

@Component
public class LoginMapper {

	public Login toEntity(LoginRequestDto loginRequestDto) {

//		return new Login(loginRequestDto.getId(), loginRequestDto.getUserName(), loginRequestDto.getPassword());
		Login login = new Login();
		login.setId(loginRequestDto.getId());
		login.setUsername(loginRequestDto.getUsername());
		login.setPassword(loginRequestDto.getPassword());
		return login;
	}

	public LoginResponseDto toResponseDto(String userName, String role) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setUsername(userName);
		loginResponseDto.setRole(role);
		return loginResponseDto;

	}

}
