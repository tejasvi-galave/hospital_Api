package com.hospital.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.SignUpDto.SignUpReqDto;
import com.hospital.service.SignUpService;

@RestController
public class SignUpController {
	@Autowired
	SignUpService signUpService;

	@PostMapping("/SignUpAccount")
	public boolean CreateAccount(@RequestBody SignUpReqDto signUpReqDto) {
		System.out.println(signUpReqDto.getName() + " " + signUpReqDto.getEmail() + " " + signUpReqDto.getPassword()
				+ " " + signUpReqDto.getPhone() + " " + signUpReqDto.getRole());
		boolean userStatus = signUpService.CreateAccount(signUpReqDto);

		return userStatus;

	}
}
