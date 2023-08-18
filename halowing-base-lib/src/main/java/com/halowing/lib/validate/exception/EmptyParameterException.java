package com.halowing.lib.validate.exception;

public class EmptyParameterException extends RuntimeException {

	private static final long serialVersionUID = 2229003570468586411L;
	
	public EmptyParameterException(String parameterName) {
		super("parameter is empty. parameterName = "+ parameterName);
	}

}
