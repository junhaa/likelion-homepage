package com.homepage.likelion.test.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.response.CustomApiResponse;
import com.homepage.likelion.test.web.dto.SimpleDto;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {

	@PostMapping("/simple")
	public CustomApiResponse<?> simple(){
		return CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원 가입에 성공했습니다.");
	}

	@GetMapping("/jsonData")
	public CustomApiResponse<SimpleDto> jsonData(){
		return CustomApiResponse.createSuccess(SimpleDto.builder()
			.email("2171326@hansung.ac.kr")
			.userId("junhaa")
			.build());
	}
}
