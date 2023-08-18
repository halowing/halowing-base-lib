package com.halowing.lib.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilityTest {

	
	public static void main(String[] args) {
		test4();
	}
	
	
	private static void test4() {
		debug("sysdate = {}",DateTimeUtility.getLocalSysdate());
		debug("utc = {}", DateTimeUtility.getUtcSysdate());
		
	}


	private static void test3() {
		String time = "2023-08-18T14:50:20.1";
		
		LocalDateTime ldt = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		System.out.println("time:"+ldt.format(DateTimeUtility.JSON_DATE_TIMESTAMP_FORMATTER));
		System.out.println("time:"+ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
	}


	private static void test2() {
		
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println("time:"+time);
	}


	private static void test1() {
		
		ZonedDateTime seoultime = ZonedDateTime.parse("2023-08-18T18:20:12+09:00");
		System.out.println(seoultime);
		
		ZonedDateTime latime = seoultime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		System.out.println(latime);
	}
	
	private static void debug(String pattern, String... args) {
		String str = pattern;
		if(args != null && args.length > 0) {
			for(int i=0; i< args.length; i++) {
				str = str.replace("{}", args[i]);
			}
		}
		
		System.out.println(str);
	}
}
