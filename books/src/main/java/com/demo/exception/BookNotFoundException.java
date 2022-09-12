package com.demo.exception;

public class BookNotFoundException extends Exception {
	public BookNotFoundException() {}

	public BookNotFoundException(String message) {
		super(message);
	}
	public BookNotFoundException(Exception e) {
		super(e);
	}
	public BookNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
