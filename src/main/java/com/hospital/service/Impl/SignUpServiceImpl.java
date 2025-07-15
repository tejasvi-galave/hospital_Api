package com.hospital.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.Dao.LoginRepository;
import com.hospital.Dao.SignUpRepository;
import com.hospital.SignUpDto.SignUpReqDto;
import com.hospital.entity.Login;
import com.hospital.entity.SignUp;
import com.hospital.mapper.SignUpMapper;
import com.hospital.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	SignUpRepository signUpRepository;
	@Autowired
	SignUpMapper signUpMapper;

	@Autowired
	LoginRepository loginRepository;

	@Transactional
	@Override
	public boolean CreateAccount(SignUpReqDto signUpReqDto) {
		SignUp signUp = signUpMapper.toEntity(signUpReqDto);
		try {
			long userCount = signUpRepository.count();
			if (userCount >= 1) {
				System.out.println("user is present");
				return false;

			}
			System.out.println("user not present");
			SignUp addedSignUp = signUpRepository.save(signUp);
			Login login = new Login();
			login.setUsername(addedSignUp.getEmail());
			login.setPassword(addedSignUp.getPassword());
			login.setRole(addedSignUp.getRole());
			loginRepository.save(login);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
