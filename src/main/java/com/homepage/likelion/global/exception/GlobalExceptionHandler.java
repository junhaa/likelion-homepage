package com.homepage.likelion.global.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.homepage.likelion.global.enums.ErrorStatus;
import com.homepage.likelion.global.response.CustomApiResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<Object> handleGeneralException(GeneralException exception, HttpServletRequest request) {
		return handlingException(exception.getHttpStatus(), exception.getErrorReason());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException exception) {

		Map<String, String> errors = new LinkedHashMap<>();
		exception.getBindingResult().getFieldErrors().stream()
			.forEach(fieldError -> {
				String fieldName = fieldError.getField();
				String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
				errors.merge(fieldName, errorMessage,
					(existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
			});

		exception.getBindingResult().getGlobalErrors().stream()
			.forEach(globalError -> {
				String objectName = globalError.getObjectName();
				String errorMessage = Optional.ofNullable(globalError.getDefaultMessage()).orElse("");
				errors.merge(objectName, errorMessage,
					(existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
			});

		return handlingException(ErrorStatus._BAD_REQUEST.getHttpStatus(), errors.toString());

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception){
		String errorMessage = exception.getConstraintViolations().stream()
			.map(ConstraintViolation::getMessage)
			.collect(Collectors.joining("; "));

		return handlingException(ErrorStatus._BAD_REQUEST.getHttpStatus(), errorMessage);
	}


	public ResponseEntity<Object> handlingException(HttpStatus httpStatus, String errorMessage) {
		return ResponseEntity
			.status(httpStatus)
			.body(CustomApiResponse.createFailWithout(httpStatus.value(), errorMessage));
	}

}
