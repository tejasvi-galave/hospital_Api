package com.hospital.Dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResDto {
	private int diagnosisId;
	private int patientId;
	private String patientName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;
	private String diagnosis;
	private String treatment;
	private String prescription;
	private String status;
}
