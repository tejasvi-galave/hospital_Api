package com.hospital.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diagnosis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diagnosis_id", nullable = false)
	private int diagnosisId;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@Column(name = "visitDate", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;

	@Column(name = "diagnosis", nullable = false)
	private String diagnosis;

	@Column(name = "treatment", nullable = false)
	private String treatment;

	@Column(name = "prescription", nullable = false)
	private String prescription;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "status", nullable = false)
	private String status;
}
