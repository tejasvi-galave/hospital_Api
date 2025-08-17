package com.hospital.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hospital.Dao.AppointmentRepository;
import com.hospital.Dto.AppointmentReqDto;
import com.hospital.Dto.AppointmentResDto;
import com.hospital.Dto.PageResponse;
import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.mapper.AppointmentMapper;
import com.hospital.service.AppointmentService;

import jakarta.persistence.EntityManager;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AppointmentMapper appointmentMapper;

	@Override
	public boolean addAppointment(AppointmentReqDto dto) {
		try {
			boolean exists = appointmentRepository.existsByDoctor_IdAndAppointmentDateAndTimeSlot(dto.getDoctorId(),
					dto.getAppointmentDate(), dto.getTimeSlot());

			if (exists) {
				return false;
			}
			Appointment appointment = appointmentMapper.toEntity(dto);
			appointment.setIsActive("Active");
			appointmentRepository.save(appointment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAppointment(AppointmentReqDto dto) {

		Appointment existing = appointmentRepository.findById(dto.getAppointmentId()).orElse(null);
		if (existing == null)
			return false;

		boolean alreadyExists = appointmentRepository.existsByDoctor_IdAndAppointmentDateAndTimeSlotAndAppointmentIdNot(
				dto.getDoctorId(), dto.getAppointmentDate(), dto.getTimeSlot(), dto.getAppointmentId());

		if (alreadyExists) {
			return false;
		}

		try {
			Doctor doctorRef = entityManager.getReference(Doctor.class, dto.getDoctorId());
			Patient patientRef = entityManager.getReference(Patient.class, dto.getPatientId());

			existing.setDoctor(doctorRef);
			existing.setPatient(patientRef);

			appointmentMapper.updateEntity(dto, existing);

			appointmentRepository.save(existing);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public PageResponse<AppointmentResDto> getAllAppointments(Pageable pageable) {
		Page<Appointment> appointmentPage = appointmentRepository.findByisActive("Active", pageable);

		List<AppointmentResDto> dtoList = appointmentPage.getContent().stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		PageResponse<AppointmentResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(appointmentPage.getNumber());
		response.setPageSize(appointmentPage.getSize());
		response.setTotalPages(appointmentPage.getTotalPages());
		response.setTotalElements(appointmentPage.getTotalElements());
		return response;
	}

	public PageResponse<AppointmentResDto> getAppointmentsByDoctorId(int doctorId, Pageable pageable) {
		Page<Appointment> appointmentPage = appointmentRepository.findByDoctor_IdAndIsActive(doctorId, "Active",
				pageable);

		List<AppointmentResDto> dtoList = appointmentPage.getContent().stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		PageResponse<AppointmentResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(appointmentPage.getNumber());
		response.setPageSize(appointmentPage.getSize());
		response.setTotalPages(appointmentPage.getTotalPages());
		response.setTotalElements(appointmentPage.getTotalElements());
		return response;
	}

	@Override
	public AppointmentResDto getAppointmentById(int id) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (appointment.isPresent()) {
			Appointment result = appointment.get();
			AppointmentResDto appointmentDto = appointmentMapper.toResDto(result);
			return appointmentDto;
		}
		return null;
	}

	@Override
	public List<AppointmentResDto> searchAppointmentByPhone(String phone) {
		List<Appointment> appointments = appointmentRepository.findByPhoneContaining(phone);

		List<AppointmentResDto> result = appointments.stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		return result;
	}

	@Override
	public List<AppointmentResDto> searchAppointmentByPhoneAndUserId(String phone, int userId) {
		List<Appointment> appointments = appointmentRepository.findByPhoneContainingAndUserId(phone, userId);

		List<AppointmentResDto> result = appointments.stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		return result;
	}

	@Override
	public PageResponse<AppointmentResDto> getAppointmentByUserId(int userId, Pageable pageable) {
		Page<Appointment> appointmentPage = appointmentRepository.findByUserIdAndIsActive(userId, "Active", pageable);

		List<AppointmentResDto> dtoList = appointmentPage.getContent().stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		PageResponse<AppointmentResDto> response = new PageResponse<>();
		response.setContent(dtoList);
		response.setCurrentPage(appointmentPage.getNumber());
		response.setPageSize(appointmentPage.getSize());
		response.setTotalPages(appointmentPage.getTotalPages());
		response.setTotalElements(appointmentPage.getTotalElements());
		return response;
	}

	@Override
	public List<AppointmentResDto> searchAppointmentByPhoneAndDoctorId(String phone, int doctorId) {
		List<Appointment> appointments = appointmentRepository.findByPhoneContainingAndDoctorId(phone, doctorId);

		List<AppointmentResDto> result = appointments.stream()
				.map(appointment -> appointmentMapper.toResDto(appointment)).collect(Collectors.toList());

		return result;
	}

	@Override
	public long getDoctorCount() {
		return appointmentRepository.count();
	}

}
