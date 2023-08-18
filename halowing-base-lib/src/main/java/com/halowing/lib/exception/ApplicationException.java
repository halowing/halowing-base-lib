package com.halowing.lib.exception;

import java.util.ResourceBundle;

public interface ApplicationException {
	
	public void setResourceBundle(ResourceBundle resourceBundle) ;

	public String getErrorCode();
	
	public String[] getArgs();
}
