package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.response.CustomApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserTestController {
	@PostMapping("/signup")
	public CustomApiResponse<?> signup(@Valid @RequestBody SignupDto dto){
		System.out.println(dto.getEmail());

		return CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입에 성공했습니다.");
	}
}
