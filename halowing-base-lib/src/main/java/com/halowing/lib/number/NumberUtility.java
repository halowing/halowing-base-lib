package com.halowing.lib.number;

import com.halowing.lib.string.StringUtility;

public class NumberUtility {
	
	public static float round(float number, int offset) {
		
		int multiple = 1;
		for(int i=0; i < offset && offset >= 0 ; i++) {
			multiple *= 10;
		}
		
		for(int i=0; i > offset && offset < 0 ; i--) {
			multiple *= 10;
		}
		
		if(offset >=0 )
			return  Math.round(number * multiple) / (multiple * 1f);
		else
			return Math.round(number / multiple) * (multiple * 1f);
	}
	
	/**
	 * 
	 * @param floatString		: NUMBER style String
	 * @param offset		: position of rounding. offset must be greater than zero. 
	 * @return
	 */
	public static String toRoundedString(String floatString, int offset) {
		
		if(StringUtility.isBlank(floatString)) 
			return "";
		
		float f = Float.valueOf(floatString) ;
		
		f = round(f, offset);
		
		if(offset >= 0)
			return  String.format("%."+offset+"f", f);
		else
			return  String.format("%f", f);
		
	}
	
	/**
	 * 
	 * @param number
	 * @param offset
	 * @return
	 */
	public static String toRoundedString(Float number, int offset) {
		
		if(number == null) return "";
		
		number = round(offset, offset);
		
		if(offset >= 0)
			return  String.format("%."+offset+"f", number);
		else
			return String.format("%f", number);
	}

}
