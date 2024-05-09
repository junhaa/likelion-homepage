package com.homepage.likelion.global.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"status", "data", "message"})
public class CustomApiResponse<T> {
	private int status;
	private T data;
	private String message;

	public static <T> CustomApiResponse<T> createSuccess(int status, T data, String message){
		return new CustomApiResponse<>(status, data, message);
	}

	public static <T> CustomApiResponse<T> createSuccess(T data){
		return createSuccess(HttpStatus.OK.value(), data,  "성공");
	}

	public static <T> CustomApiResponse<T>  createFailWithout(int status, String message){
		return new CustomApiResponse<>(status, null, message);
	}

	public static <T> CustomApiResponse<T> createFailWithout(HttpStatus httpStatus){
		return new CustomApiResponse<>(httpStatus.value(), null, "실패");
	}
}
