package com.hospital.service;

import org.springframework.stereotype.Service;

import com.hospital.SignUpDto.SignUpReqDto;

@Service
public interface SignUpService {

	boolean CreateAccount(SignUpReqDto signUpReqDto);

}
