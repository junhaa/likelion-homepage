package com.homepage.likelion.post.presentation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.response.CustomApiResponse;
import com.homepage.likelion.post.presentation.dto.PostRequestDto;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;
import com.homepage.likelion.post.service.PostCommandService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {
	private final PostCommandService postCommandService;


	@PostMapping()
	public CustomApiResponse<PostResponseDto.PostCreateResponseDto> createPost(@Valid @RequestBody PostRequestDto.PostCreateDto request){
		return CustomApiResponse.createSuccess(postCommandService.createPost(request));
	}
}
