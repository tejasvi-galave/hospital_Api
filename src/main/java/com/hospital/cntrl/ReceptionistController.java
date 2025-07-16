package com.hospital.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Dto.ReceptionistReqDto;
import com.hospital.Dto.ReceptionistResDto;
import com.hospital.service.ReceptionistService;

@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {
	@Autowired
	private ReceptionistService receptionistService;

	@PostMapping("/add")
	public boolean saveReceptionist(@RequestBody ReceptionistReqDto receptionistReqDto) {
		boolean isAdded = receptionistService.saveReceptionist(receptionistReqDto);
		return isAdded;
	}

	@GetMapping("/all")
	public List<ReceptionistResDto> findAllReceptionist() {
		List<ReceptionistResDto> list = receptionistService.findAllReceptionist();
		return list;
	}

	@PostMapping("/update")
	public boolean update(@RequestBody ReceptionistReqDto dto) {
		boolean isUpdated = receptionistService.update(dto);
		return isUpdated;
	}
}
