package com.hospital.Dto;

import lombok.Getter;
import lombok.Setter;

public class DoctorResponseDto {
	@Getter
	@Setter
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}
