package com.homepage.likelion.global.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.enums.ErrorStatus;
import com.homepage.likelion.global.response.CustomApiResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public ResponseEntity<CustomApiResponse<?>> handleError(HttpServletRequest request){
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		ErrorStatus errorStatus = null;
		if(status != null) {
			int statusCode = Integer.parseInt(status.toString());
			if (statusCode == HttpStatus.BAD_REQUEST.value())
				errorStatus = ErrorStatus._BAD_REQUEST;
			else if (statusCode == HttpStatus.UNAUTHORIZED.value())
				errorStatus = ErrorStatus._UNAUTHORIZED;
			else if (statusCode == HttpStatus.FORBIDDEN.value())
				errorStatus = ErrorStatus._FORBIDDEN;
			else if (statusCode == HttpStatus.NOT_FOUND.value())
				errorStatus = ErrorStatus._NOT_FOUND;
			else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value())
				errorStatus = ErrorStatus._METHOD_NOT_ALLOWED;
			else
				errorStatus = ErrorStatus._INTERNAL_SERVER_ERROR;
		}
		else errorStatus = ErrorStatus._INTERNAL_SERVER_ERROR;

		return ResponseEntity
			.status(errorStatus.getHttpStatus())
			.body(CustomApiResponse.createFailWithout(errorStatus.getHttpStatus().value(), errorStatus.getMessage()));
	}

}
