package com.homepage.likelion.post.converter;

import com.homepage.likelion.post.domain.Post;
import com.homepage.likelion.post.presentation.dto.PostRequestDto;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;

public class PostConverter {
	public static PostResponseDto.PostCreateResponseDto toPostCreateResponseDto(Post post){
		return PostResponseDto.PostCreateResponseDto.builder()
			.post_id(post.getId())
			.updated_at(post.getUpdatedAt())
			.build();
	}

	public static Post toPost(PostRequestDto.PostCreateDto request, String encodePassword){
		return Post.builder()
			.postedUserName(request.getPostedUserName())
			.password(encodePassword)
			.title(request.getTitle())
			.content(request.getContent())
			.build();
	}

	public static PostResponseDto.PostDetailDto toPostDetailDto(Post post){
		return PostResponseDto.PostDetailDto.builder()
			.posted_user_name(post.getPostedUserName())
			.title(post.getTitle())
			.content(post.getContent())
			.created_at(post.getCreatedAt())
			.updated_at(post.getUpdatedAt())
			.build();
	}
}
