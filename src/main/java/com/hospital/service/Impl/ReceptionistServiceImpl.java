package com.hospital.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.Dao.LoginRepository;
import com.hospital.Dao.ReceptionistRepository;
import com.hospital.Dto.ReceptionistReqDto;
import com.hospital.Dto.ReceptionistResDto;
import com.hospital.entity.Login;
import com.hospital.entity.Receptionist;
import com.hospital.mapper.ReceptionistMapper;
import com.hospital.service.ReceptionistService;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {

	@Autowired
	private ReceptionistRepository receptionistRepository;

	@Autowired
	private ReceptionistMapper receptionistMapper;
	@Autowired
	LoginRepository loginRepository;

	@Transactional
	@Override
	public boolean saveReceptionist(ReceptionistReqDto receptionistReqDto) {
		try {
			Receptionist receptionist = receptionistMapper.toEntity(receptionistReqDto);
			receptionistRepository.save(receptionist);
			Login login = new Login();
			login.setUsername(receptionist.getEmail());
			login.setPassword("demo");
			login.setRole("receptionist");
			loginRepository.save(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReceptionistResDto> findAllReceptionist() {
		List<Receptionist> receptionist = (List<Receptionist>) receptionistRepository.findAll();

		List<ReceptionistResDto> dtoList = receptionist.stream()
				.map(receptionistList -> receptionistMapper.toResDto(receptionistList)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public boolean update(ReceptionistReqDto receptionistReqDto) {
		try {
			Optional<Receptionist> opt = receptionistRepository.findById(receptionistReqDto.getId());

			if (opt.isEmpty()) {
				return false;
			}

			Receptionist existingReceptionist = opt.get();
			String oldEmail = existingReceptionist.getEmail();

			Receptionist updated = receptionistMapper.toEntity(receptionistReqDto);

			Receptionist saved = receptionistRepository.save(updated);

			if (!oldEmail.equals(saved.getEmail())) {
				Optional<Login> loginOpt = loginRepository.findByUsername(oldEmail);
				if (loginOpt.isPresent()) {
					Login login = loginOpt.get();
					login.setUsername(saved.getEmail());
					loginRepository.save(login);
				}
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
