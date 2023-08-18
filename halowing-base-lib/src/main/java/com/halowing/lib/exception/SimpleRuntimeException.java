package com.halowing.lib.exception;

/**
 * It is a RuntimeException Wrapper.
 * It is used to handle that do not use ResourceBundle.
 */
public class SimpleRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 4793274607807687071L;

	public SimpleRuntimeException(Throwable cause) {
		super(cause);
	}
	
	public SimpleRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SimpleRuntimeException(String message) {
		super(message);
	}

}
