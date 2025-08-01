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
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private String phone;

	@Column(name = "bloodgroup")
	private String bloodGroup;

	@Column(name = "address")
	private String address;

	@Column(name = "medical_history")
	private String medicalHistory;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "status")
	private String status;

	public Patient(int id) {
		this.id = id;
	}

}
