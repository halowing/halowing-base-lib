package com.halowing.lib.validate;

import java.util.Collection;

import com.halowing.lib.validate.exception.BlinkStringParameterException;
import com.halowing.lib.validate.exception.EmptyParameterException;
import com.halowing.lib.validate.exception.NullParameterException;

/**
 * check input parameter
 * @author sgkim
 *
 */
public class ParameterCheck {
	/**
	 * if parameter is null then throw NullParameterException.
	 * 
	 * @param parameter       : input value
	 * @param parameterName   : parameter name 
	 */
	public static void isNotNull(Object parameter, String parameterName) {
		if(parameter == null)
			throw new NullParameterException(parameterName);
	}
	
	/**
	 * If input value is empty - length is zero - then throw EmptyParameterException.
	 * It also check Null parameter.
	 * 
	 * @param parameter
	 * @param parameterName
	 */
	public static void isNotEmpty(String parameter, String parameterName) {
		
		isNotNull(parameter, parameterName);
		
		if(parameter.length() == 0)
			throw new EmptyParameterException(parameterName);
	}
	
	/**
	 * If Collection has not data then it throw EmptyParameterException.
	 * 
	 * @param <T>
	 * @param collection
	 * @param parameterName
	 */
	public static <T> void isNotEmpty(Collection<T> collection, String parameterName) {
		isNotNull(collection, parameterName);
		
		if(collection.size() == 0)
			throw new EmptyParameterException(parameterName);
	}
	
	public static void isNotBlink(String parameter, String parameterName) {
		
		isNotEmpty(parameter, parameterName);
		
		if(parameter.trim().length() == 0)
			throw new BlinkStringParameterException(parameterName);
	}

}
