package com.hospital.entity;

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
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "bloodgroup", nullable = false)
	private String bloodGroup;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "medical_history", nullable = false)
	private String medicalHistory;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "status", nullable = false)
	private String status;

	public Patient(int id) {
		this.id = id;
	}
}
