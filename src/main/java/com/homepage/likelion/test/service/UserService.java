package com.homepage.likelion.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homepage.likelion.global.enums.ErrorStatus;
import com.homepage.likelion.global.exception.GeneralException;
import com.homepage.likelion.global.response.CustomApiResponse;
import com.homepage.likelion.test.domain.User;
import com.homepage.likelion.test.repository.UserRepository;
import com.homepage.likelion.test.web.dto.UserSignupDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
	private final UserRepository userRepository;

	public CustomApiResponse<?> signup(UserSignupDto request){
		if(userRepository.findByUserId(request.getUserId()).isPresent()) throw new GeneralException(ErrorStatus._USER_ID_DUPLICATE);

		User user = User.builder()
			.userId(request.getUserId())
			.password(request.getPassword())
			.email(request.getEmail())
			.build();

		return CustomApiResponse.createSuccess(user);
	}
}
