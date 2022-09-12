package com.demo.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.exception.BookNotFoundException;
import com.demo.model.ErrorResponse;


@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException e) {
		ErrorResponse error = new ErrorResponse(500, e.getClass().toString(), e.getMessage(), null, LocalDateTime.now());
//		return error;
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

	
}
