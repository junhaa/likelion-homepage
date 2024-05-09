package com.homepage.likelion.global.enums;

import org.springframework.http.HttpStatus;

public interface BaseCode {
	String getCode();

	String getMessage();

	HttpStatus getHttpStatus();

	Integer getStatusValue();
}
