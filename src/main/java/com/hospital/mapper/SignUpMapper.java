package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.SignUpDto.SignUpReqDto;
import com.hospital.SignUpDto.SignUpResDto;
import com.hospital.entity.SignUp;

@Component
public class SignUpMapper {

	public SignUp toEntity(SignUpReqDto signUpReqDto) {
		return new SignUp(signUpReqDto.getId(), signUpReqDto.getName(), signUpReqDto.getEmail(),
				signUpReqDto.getPassword(), signUpReqDto.getPhone(), signUpReqDto.getRole());
	}

	public SignUpResDto toDto(SignUp addedSignUp) {
		SignUpResDto resDto = new SignUpResDto();
		resDto.setEmail(addedSignUp.getEmail());
		resDto.setPassword(addedSignUp.getPassword());
		return resDto;
	}

}
