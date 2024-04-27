package com.halowing.lib.exception;

import java.util.Locale;

public class SimpleApplicationExceptionTest {

	
	public static void main(String[] args) {
		final String errorCode = "test.echo";
		SimpleApplicationException e = new SimpleApplicationException(errorCode, "hello world");
		
		System.out.println(String.format("Default Local is %s.", Locale.getDefault()));
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
}
