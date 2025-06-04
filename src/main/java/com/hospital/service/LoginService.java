package com.hospital.service;

import org.springframework.stereotype.Service;

import com.hospital.loginDto.LoginRequestDto;
import com.hospital.loginDto.LoginResponseDto;

@Service
public interface LoginService {

	LoginResponseDto checkExistAccount(LoginRequestDto loginRequestDto);

}
