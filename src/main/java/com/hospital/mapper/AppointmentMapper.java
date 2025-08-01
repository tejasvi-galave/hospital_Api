package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.Dto.AppointmentReqDto;
import com.hospital.Dto.AppointmentResDto;
import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;

@Component
public class AppointmentMapper {

	public Appointment toEntity(AppointmentReqDto dto) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(dto.getAppointmentId());
		appointment.setPatient(new Patient(dto.getPatientId()));
		appointment.setDoctor(new Doctor(dto.getDoctorId()));

		appointment.setAppointmentDate(dto.getAppointmentDate());
		appointment.setTimeSlot(dto.getTimeSlot());
		appointment.setStatus(dto.getStatus());
		appointment.setIsActive(dto.getIsActive());
		appointment.setUserId(dto.getUserId());
		appointment.setPhone(dto.getPhone());
		return appointment;
	}

	public AppointmentResDto toResDto(Appointment appointment) {
		AppointmentResDto dto = new AppointmentResDto();
		dto.setAppointmentId(appointment.getAppointmentId());
		dto.setPatientId(appointment.getPatient().getId());
		dto.setDoctorId(appointment.getDoctor().getId());
		String doctorName = appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName();
		dto.setDoctorName(doctorName);
		dto.setPatientName(appointment.getPatient().getName());
		dto.setAppointmentDate(appointment.getAppointmentDate());
		dto.setTimeSlot(appointment.getTimeSlot());
		dto.setStatus(appointment.getStatus());
		dto.setPhone(appointment.getPhone());
		dto.setIsActive(appointment.getIsActive());

		return dto;
	}

	public Appointment updateEntity(AppointmentReqDto dto, Appointment appointment) {
		appointment.setAppointmentDate(dto.getAppointmentDate());
		appointment.setTimeSlot(dto.getTimeSlot());
		appointment.setStatus(dto.getStatus());
		appointment.setUserId(dto.getUserId());
		appointment.setPhone(dto.getPhone());
		return appointment;

	}

}
