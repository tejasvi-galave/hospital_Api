package com.hospital.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Dto.AppointmentReqDto;
import com.hospital.Dto.AppointmentResDto;
import com.hospital.Dto.DoctorResponseDto;
import com.hospital.Dto.PageResponse;
import com.hospital.service.AppointmentService;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	DoctorService doctorService;

	@PostMapping("/add")
	public boolean addAppointment(@RequestBody AppointmentReqDto dto) {
		boolean result = appointmentService.addAppointment(dto);
		return result;
	}

	@PostMapping("/update")
	public boolean updateAppointment(@RequestBody AppointmentReqDto dto) {
		boolean result = appointmentService.updateAppointment(dto);
		return result;
	}

	@GetMapping("/all/{page}/{size}")
	public PageResponse<AppointmentResDto> getAllAppointments(@PathVariable int page, @PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return appointmentService.getAllAppointments(pageable);
	}

	@GetMapping("/getByDoctorId/{doctorId}/{page}/{size}")
	public PageResponse<AppointmentResDto> getAppointmentsByDoctor(@PathVariable int doctorId, @PathVariable int page,
			@PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return appointmentService.getAppointmentsByDoctorId(doctorId, pageable);
	}

	@GetMapping("/getDoctors")
	public List<DoctorResponseDto> findAllDoctors() {
		List<DoctorResponseDto> doctors = doctorService.getAllDoctor();
		return doctors;
	}

	@GetMapping("/appointmentById/{id}")
	public AppointmentResDto getAppointmentById(@PathVariable int id) {
		AppointmentResDto appointmentResDto = appointmentService.getAppointmentById(id);
		return appointmentResDto;
	}

	@GetMapping("/searchbyPhone/{phone}")
	public List<AppointmentResDto> searchAppointmentByPhone(@PathVariable String phone) {
		return appointmentService.searchAppointmentByPhone(phone);
	}

	@GetMapping("/search-appointment-byPhone/{phone}/{userId}")
	public List<AppointmentResDto> searchAppointmentByPhoneAndUserId(@PathVariable String phone,
			@PathVariable int userId) {
		return appointmentService.searchAppointmentByPhoneAndUserId(phone, userId);
	}

	@GetMapping("/byUserId/{userId}/{page}/{size}")
	public PageResponse<AppointmentResDto> getAppointmentByUserId(@PathVariable int userId, @PathVariable int page,
			@PathVariable int size) {
		Pageable pageable = PageRequest.of(page, size);
		return appointmentService.getAppointmentByUserId(userId, pageable);
	}

	@GetMapping("/search-byPhoneAndDoctorId/{phone}/{doctorId}")
	public List<AppointmentResDto> searchAppointmentByPhoneAndDoctorId(@PathVariable String phone,
			@PathVariable int doctorId) {
		return appointmentService.searchAppointmentByPhoneAndDoctorId(phone, doctorId);
	}
}
