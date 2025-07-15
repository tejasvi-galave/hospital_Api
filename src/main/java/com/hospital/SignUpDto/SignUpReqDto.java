package com.hospital.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpReqDto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String role;

}
