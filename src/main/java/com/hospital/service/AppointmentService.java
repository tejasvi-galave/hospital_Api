package com.hospital.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dto.AppointmentReqDto;
import com.hospital.Dto.AppointmentResDto;
import com.hospital.Dto.PageResponse;

@Service
public interface AppointmentService {
	boolean addAppointment(AppointmentReqDto dto);

	boolean updateAppointment(AppointmentReqDto dto);

	PageResponse<AppointmentResDto> getAllAppointments(Pageable pageable);

	PageResponse<AppointmentResDto> getAppointmentsByDoctorId(int doctorId, Pageable pageable);

	AppointmentResDto getAppointmentById(int id);

	List<AppointmentResDto> searchAppointmentByPhone(String phone);

	List<AppointmentResDto> searchAppointmentByPhoneAndUserId(String phone, int userId);

	PageResponse<AppointmentResDto> getAppointmentByUserId(int userId, Pageable pageable);

	List<AppointmentResDto> searchAppointmentByPhoneAndDoctorId(String phone, int doctorId);

	long getDoctorCount();
}
