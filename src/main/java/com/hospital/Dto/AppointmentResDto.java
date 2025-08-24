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
public class AppointmentResDto {
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private String patientName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	private String doctorName;
	private String timeSlot;
	private String status;
	private String phone;
	private String isActive;
}
