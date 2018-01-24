package com.api.address.exception;

public class InvalidValueException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidValueException() {
		super();
	}

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidValueException(Throwable cause) {
		super(cause);
	}

	protected InvalidValueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
