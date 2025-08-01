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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private int appointmentId;
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;

	@NotNull(message = "Appointment date is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "appointment_date", nullable = false)
	private LocalDate appointmentDate;

	@NotNull(message = "Time slot is required")
	@Column(name = "time_slot", nullable = false)
	private String timeSlot;

	@NotNull(message = "status  is required")
	@Column(name = "status")
	private String status;

	@Column(name = "is_active", nullable = false)
	private String isActive;

	@NotNull(message = "userId number is required")
	@Column(name = "user_id")
	private int userId;

	@NotNull(message = "phone number is required")
	@Column(name = "phone")
	private String phone;
}
