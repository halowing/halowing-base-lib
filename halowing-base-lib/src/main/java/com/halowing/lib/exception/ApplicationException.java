package com.halowing.lib.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class ApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 3891560626876962940L;

	public ApplicationException(String message, Throwable t) {
		super(message, t);
	}
	
	public ApplicationException(Throwable t) {
		super(t);
	}
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public abstract String getErrorCode();
	
	public abstract String[] getArgs();
	
	public abstract String getLocalizedMessage(Locale locale);
	
	public static String getLocaleMessage(
			ResourceBundle resourceBundle, 
			Throwable e,
			String code, 
			String[] args
			) {
		
		if(resourceBundle == null)
		{
			if(e == null)
				throw new DefaultApplicationException(new NullPointerException("resource bundle is null"));
			else
				return e.getLocalizedMessage();
		}
		
		if(code == null || code.trim().isEmpty() )
		{
			if( e == null)
				throw new DefaultApplicationException(new NullPointerException("code is null or blank"));
			else
				return e.getLocalizedMessage();
		}
		
		try {
			String message = resourceBundle.getString(code);
			
			for(int i=0 ; args != null && i < args.length; i++) {
				message = message.replaceAll("\\{"+i+"\\}", args[i]);
			}
			
			return message;
		} catch (Exception e2) {
			if( e == null)
				throw e2;
			else
				return e.getLocalizedMessage();
		}
		
		
	}
}
