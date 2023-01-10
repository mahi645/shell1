package com.axis.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> noIdFound(ResourceNotFoundException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo> (errorInfo,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorInfo> noNameFound(InvalidNameException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo> (errorInfo,HttpStatus.BAD_REQUEST);
	}

}
