package com.hospital.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResDto {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String phone;
	private String bloodGroup;
	private String address;
	private String medicalHistory;
	private String status;
}
