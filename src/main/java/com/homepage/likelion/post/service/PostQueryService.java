package com.homepage.likelion.post.service;

import java.util.List;

import com.homepage.likelion.post.presentation.dto.PostResponseDto;

public interface PostQueryService {
	PostResponseDto.PostDetailDto getOnePost(Long postId);
	List<PostResponseDto.PostDetailDto> getAllPost();
	// List<PostResponseDto.PostDetailDto> getUserPost(Long userId);
}
