package com.homepage.likelion.post.presentation.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostResponseDto {

	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PostCreateResponseDto{
		private Long post_id;
		private LocalDateTime updated_at;
	}



	@Builder
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class PostDetailDto{
		private String posted_user_name;
		private String title;
		private String content;
		private LocalDateTime created_at;
		private LocalDateTime updated_at;
	}
}

