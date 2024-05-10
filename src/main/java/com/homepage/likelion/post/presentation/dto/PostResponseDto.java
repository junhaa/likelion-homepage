package com.homepage.likelion.post.presentation.dto;

import java.time.LocalDateTime;

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
}
