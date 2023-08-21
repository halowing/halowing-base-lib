package com.halowing.lib.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class SimpleApplicationException extends ApplicationException {

	private static final long serialVersionUID = -8732186396685769772L;
	
	private static final String MESSAGE_RESOURCE = "messages/messages";
	
	private static final ResourceBundle RESOURCE_BUNDLE_US     = ResourceBundle.getBundle(MESSAGE_RESOURCE, Locale.US);
	private static final ResourceBundle LOCALE_RESOURCE_BUNDLE = ResourceBundle.getBundle(MESSAGE_RESOURCE, Locale.getDefault());
	
	private final String errorCode ;
	private final String[] args ;
	
	
	public SimpleApplicationException(Throwable e, String errorCode, String...args ) {
		super(getMessage(errorCode, args), e );
		this.errorCode = errorCode;
		this.args = args;
	}
	
	public SimpleApplicationException(Throwable e) {
		super( e );
		this.errorCode = null;
		this.args = null;
	}
	
	public SimpleApplicationException(String errorCode, String...args) {
		super(getMessage(errorCode, args));
		this.errorCode = errorCode;
		this.args = args;
	}
	
	
	public SimpleApplicationException(SimpleApplicationException e) {
		super(e);
		this.errorCode = e.getErrorCode();
		this.args = e.getArgs();
	}
	
	protected static String getMessage( String errorCode, String[] args) {
		return ApplicationException.getLocaleMessage(RESOURCE_BUNDLE_US, null, errorCode, args);
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
		
		try {
			return ApplicationException.getLocaleMessage(LOCALE_RESOURCE_BUNDLE, null, this.errorCode, this.args);
		} catch (Exception e) {
			return super.getLocalizedMessage();
		}
		
		
	}
	
	@Override
	public String getLocalizedMessage(Locale locale) {
		
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_RESOURCE, locale);
			return ApplicationException.getLocaleMessage(bundle, getCause(), this.errorCode, this.args);
		} catch (Exception e) {
			return super.getLocalizedMessage();
		}
		
	}
}
