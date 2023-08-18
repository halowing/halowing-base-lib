package com.halowing.lib.validate.exception;

public class NullParameterException extends RuntimeException {

	private static final long serialVersionUID = 2229003570468586411L;
	
	public NullParameterException(String parameterName) {
		super("parameter is null. parameterName = "+ parameterName);
	}

}
