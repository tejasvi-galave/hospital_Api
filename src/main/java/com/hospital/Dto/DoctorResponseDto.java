package com.hospital.Dto;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String department;
	private String speciality;
	@DateTimeFormat(pattern = "H:M")
	private LocalTime fromTime;
	@DateTimeFormat(pattern = "H:M")
	private LocalTime toTime;
}
