package com.halowing.lib;

public class Console {

	public static void log(String pattern, String... args) {
		String str = pattern;
		if(args != null && args.length > 0) {
			for(int i=0; i< args.length; i++) {
				str = str.replace("{}", args[i]);
			}
		}
		
		System.out.println(str);
	}
	
	public static void log(String pattern, Object... args) {
		String str = pattern;
		if(args != null && args.length > 0) {
			for(int i=0; i< args.length; i++) {
				str = str.replace("{}", args[i].toString());
			}
		}
		
		System.out.println(str);
	}
	
	public static void log(Object obj) {
		
		System.out.println(obj.toString());
	}
}
