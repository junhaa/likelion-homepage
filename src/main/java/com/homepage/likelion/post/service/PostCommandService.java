package com.homepage.likelion.post.service;

import com.homepage.likelion.post.presentation.dto.PostRequestDto;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;

public interface PostCommandService {
	PostResponseDto.PostCreateResponseDto createPost(PostRequestDto.PostCreateDto requst);
	PostResponseDto.PostCreateResponseDto modifyPost(PostRequestDto.PostCreateDto request, Long postId);
}
