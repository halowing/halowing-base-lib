package com.halowing.lib.validate.exception;

public class BlinkStringParameterException extends RuntimeException {

	private static final long serialVersionUID = 2229003570468586411L;
	
	public BlinkStringParameterException(String parameterName) {
		super("parameter has only space text. parameterName = "+ parameterName);
	}

}
