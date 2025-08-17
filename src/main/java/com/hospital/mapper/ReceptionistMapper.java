package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.Dto.ReceptionistReqDto;
import com.hospital.Dto.ReceptionistResDto;
import com.hospital.entity.Receptionist;

@Component
public class ReceptionistMapper {

	public Receptionist toEntity(ReceptionistReqDto dto) {
		Receptionist entity = new Receptionist();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDob(dto.getDob());
		entity.setUserId(dto.getUserId());
		entity.setStatus(dto.getStatus());

		return entity;
	}

	public ReceptionistResDto toResDto(Receptionist entity) {
		ReceptionistResDto dto = new ReceptionistResDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setDob(entity.getDob());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}
