package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entity.Contact;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Contact> contactNotfoundExceptionHandler(CustomException exception) {
		String message = exception.getMessage();
		Contact contact = new Contact();
		return new ResponseEntity<Contact>(contact, HttpStatus.NOT_FOUND);

	}
}
