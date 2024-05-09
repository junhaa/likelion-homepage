package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.util.response.CustomApiResponse;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {

	@PostMapping("/simple")
	public CustomApiResponse<?> simple(){
		return CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원 가입에 성공했습니다.");
	}
}
