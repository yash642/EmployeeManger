package com.cg.tasktracker.exceptions;

public class AuthenticationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
	public AuthenticationException(String message) {
		super(message);
	}
	public AuthenticationException(Throwable cause) {
		super(cause);
	}
}
