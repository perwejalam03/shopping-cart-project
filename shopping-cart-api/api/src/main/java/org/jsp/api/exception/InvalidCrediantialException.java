package org.jsp.api.exception;


public class InvalidCrediantialException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Crediantials";
	}
}
