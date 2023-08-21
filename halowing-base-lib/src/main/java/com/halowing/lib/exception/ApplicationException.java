package com.halowing.lib.exception;

import java.util.Locale;

public interface ApplicationException {
	
	public String getErrorCode();
	
	public String[] getArgs();
	
	public String getLocalizedMessage(Locale locale);
}
