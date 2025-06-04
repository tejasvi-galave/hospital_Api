package com.hospital.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.loginDto.LoginRequestDto;
import com.hospital.loginDto.LoginResponseDto;
import com.hospital.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/checkAccount")
	public LoginResponseDto checkExistAccount(@RequestBody LoginRequestDto loginRequestDto) {
		System.out.println(loginRequestDto.getUserName() + "");
		LoginResponseDto responseDto = loginService.checkExistAccount(loginRequestDto);
		return responseDto;

	}
}
