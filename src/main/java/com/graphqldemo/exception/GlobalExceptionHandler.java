package com.graphqldemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TutorialNotFoundException.class)
	public String employeeNotFoundException(TutorialNotFoundException exception){
		return exception.getMessage();
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public String employeeNotFoundException(AuthorNotFoundException exception){
		return exception.getMessage();
	}
}
