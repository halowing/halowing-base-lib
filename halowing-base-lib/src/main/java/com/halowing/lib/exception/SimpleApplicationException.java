package com.halowing.lib.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class SimpleApplicationException extends RuntimeException implements ApplicationException {

	private static final long serialVersionUID = -8732186396685769772L;
	
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages/error", Locale.getDefault());
	
	private final String errorCode ;
	private final String[] args ;
	
	public SimpleApplicationException(Throwable e, String errorCode, String...args ) {
		super(getLocaleMessage(errorCode, args), e );
		this.errorCode = errorCode;
		this.args = args;
	}
	
	public SimpleApplicationException(Throwable e) {
		this(e,null);
	}
	
	public SimpleApplicationException(String errorCode, String...args) {
		super(getLocaleMessage(errorCode, args));
		this.errorCode = errorCode;
		this.args = args;
	}
	
	
	public SimpleApplicationException(SimpleApplicationException e) {
		super(e);
		this.errorCode = e.getErrorCode();
		this.args = e.getArgs();
	}
	
	protected static String getLocaleMessage(String code, String[] args) {
		
		if(code == null || code.trim().isEmpty())
			return "";
		
		String message = RESOURCE_BUNDLE.getString(code);
		
		for(int i=0 ; args != null && i < args.length; i++) {
			message = message.replace("{}", args[i]);
		}
		
		return message;
	}
	
	
	@Override
	public String getErrorCode() {
		return errorCode;
	}
	
	@Override
	public String[] getArgs() {
		return args;
	}
	
	@Override
	public String getLocalizedMessage() {
		return getLocaleMessage(this.errorCode, this.args);
	}
	
	@Override
	public String getLocalizedMessage(Locale locale) {
		RESOURCE_BUNDLE = ResourceBundle.getBundle("messages/error", locale);
		return getLocaleMessage(this.errorCode, this.args);
	}
}
