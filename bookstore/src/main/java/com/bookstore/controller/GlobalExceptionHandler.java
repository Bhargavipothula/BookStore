package com.bookstore.controller;

import org.hibernate.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoResourceFoundException.class)
	public String handleNoResourceFound() {
        return "customErrorPage";


	}
}
