package com.halowing.lib.exception;

/**
 * It is a RuntimeException Wrapper.
 * It is used to handle that do not use ResourceBundle.
 */
public class DefaultApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 4793274607807687071L;

	public DefaultApplicationException(Throwable cause) {
		super(cause);
	}
	
	public DefaultApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DefaultApplicationException(String message) {
		super(message);
	}

}
