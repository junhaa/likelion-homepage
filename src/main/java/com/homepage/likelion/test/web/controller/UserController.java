package com.homepage.likelion.test.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.response.CustomApiResponse;
import com.homepage.likelion.test.service.UserService;
import com.homepage.likelion.test.web.dto.UserSignupDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	@PostMapping("/signup")
	public CustomApiResponse<?> signup(@Valid @RequestBody UserSignupDto request){
		return userService.signup(request);
	}
}
