package com.hospital.Dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentReqDto {
	private int appointmentId;
	private int patientId;

	private int doctorId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;

	private String timeSlot;

	private String status;
	private String isActive;
	private int userId;
	private String phone;

}
