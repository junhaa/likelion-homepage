package com.homepage.likelion.test.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupDto {
	@NotBlank(message =  "userId는 필수값입니다.")
	private String userId;
	@Email
	private String email;
	private String password;
}
