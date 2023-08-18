package com.halowing.lib.string;

import com.halowing.lib.Console;

public class StringUtilityTest {
	
	 public static void main(String[] args) {
		 test1();
	 }

	private static void test1() {
		
		String str = "a";
		
		Console.log("str is blink ? {}", StringUtility.isBlank(str));
		
	}
	 
	 
}
