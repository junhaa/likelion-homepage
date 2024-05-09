package com.homepage.likelion.global.exception;

import org.springframework.http.HttpStatus;

import com.homepage.likelion.global.enums.BaseCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeneralException extends RuntimeException{
	private final BaseCode errorStatus;

	public String getErrorCode() {
		return errorStatus.getCode();
	}

	public String getErrorReason() {
		return errorStatus.getMessage();
	}

	public HttpStatus getHttpStatus() {
		return errorStatus.getHttpStatus();
	}
}
