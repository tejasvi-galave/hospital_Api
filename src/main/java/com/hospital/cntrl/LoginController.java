package com.hospital.cntrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.loginDto.LoginRequestDto;
import com.hospital.loginDto.LoginResponseDto;
import com.hospital.service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/internalCheck")
	public LoginResponseDto checkExistAccount(@RequestBody LoginRequestDto loginRequestDto) {
		System.out.println(loginRequestDto.getUsername() + "");
		LoginResponseDto responseDto = loginService.checkExistAccount(loginRequestDto);
		return responseDto;

	}
}
