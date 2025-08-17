package com.hospital.entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id", nullable = false)
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "department", nullable = false)
	private String department;

	@Column(name = "speciality", nullable = false)
	private String speciality;

	@JsonFormat(pattern = "HH:mm")
	@Column(name = "from_time", nullable = false)
	private LocalTime fromTime;

	@JsonFormat(pattern = "HH:mm")
	@Column(name = "to_time", nullable = false)
	private LocalTime toTime;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "status", nullable = false)
	private String status;

	public Doctor(int doctorId) {
		this.id = doctorId;
	}

}
