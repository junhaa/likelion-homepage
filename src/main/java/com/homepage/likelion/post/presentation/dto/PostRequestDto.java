package com.homepage.likelion.post.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class PostRequestDto {
	@Getter
	@Setter
	public static class PostCreateDto{
		@NotBlank(message = "작성자 이름을 작성해주세요.")
		private String postedUserName;
		@NotBlank(message = "비밀번호를 작성해주세요.")
		private String password;
		@NotBlank(message = "게시글 이름을 작성해주세요.")
		private String title;
		@NotBlank(message = "게시글 내용을 작성해주세요.")
		private String content;

	}
}
