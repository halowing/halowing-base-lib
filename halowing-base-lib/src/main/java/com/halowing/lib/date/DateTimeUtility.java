package com.halowing.lib.date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtility {
	
	public final static DateTimeFormatter DB_DATE_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
	public final static DateTimeFormatter DB_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public final static DateTimeFormatter DB_DATE_FORMATTER =  DateTimeFormatter.ofPattern("yyyyMMdd");
	public final static DateTimeFormatter DB_TIME_FORMATTER =  DateTimeFormatter.ofPattern("HHmmss");
	public final static DateTimeFormatter DB_HOUR_MINUTE_FORMATTER =  DateTimeFormatter.ofPattern("HHmm");

	public final static DateTimeFormatter JSON_DATE_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
	public final static DateTimeFormatter JSON_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	public final static DateTimeFormatter JSON_TIME_FORMATTER =  DateTimeFormatter.ofPattern("HH:mm:ss");
	public final static DateTimeFormatter JSON_HOUR_MINUTE_FORMATTER =  DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * 주어진 zone 값을 이용하여 ZonedDateTime을 생성한다.
	 * 
	 * @param utcTime       : pattern : "yyyy-MM-dd'T'HH:mm:ss.[SSS]"
	 * @param zone			: example : "Asia/Seoul"
	 * @return
	 */
	public static ZonedDateTime parseZonedDateTimeFromUtcTime(String utcTime, String zone) {
		LocalDateTime localDateTime = LocalDateTime.parse(utcTime, DateTimeFormatter.ISO_DATE_TIME);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(zone));
		return zonedDateTime;
	}
	
	/**
	 * System의 ZoneId를 이용하여 ZonedDateTime을 생성한다.
	 * 
	 * @param utcTime      : pattern : "yyyy-MM-dd'T'HH:mm:ss"
	 * @return
	 */
	public static ZonedDateTime parseZonedDateTimeOfSystem(String utcTime) {
		LocalDateTime localDateTime = LocalDateTime.parse(utcTime, DateTimeFormatter.ISO_DATE_TIME);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		return zonedDateTime;
	}
	
	/**
	 * 
	 * @param date
	 * @param formatPattern
	 * @return
	 */
	public static String dateToString(Date date, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		return sdf.format(date);
	}
	
	/**
	 * 
	 * @param time
	 * @param formatPattern
	 * @return
	 */
	public static String localDatetimeToString(LocalDateTime time, String formatPattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		return time.format(formatter);
	}
	
	
	/**
	 * 주어진 시간값을 요청한 formatPattern 형태로 출력
	 * @param time
	 * @param formatPattern
	 * @return
	 */
	public static String zonedDateTimeToString(ZonedDateTime time, String formatPattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		return time.format(formatter);
	}
	
	
	
	/**
	 * 현재 시간을 UTC time으로 반환, 
	 * pattern 예제 : yyyyMMddHHmmss, yyyy-MM-dd HH:mm:ss.SSS
	 * @param pattern
	 * @return
	 */
	public static String getUtcSysdate(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));
		return time.format(formatter);
	}
	
	/**
	 * UTC 현재 시간을 "yyyy-MM-dd'T'HH:mm:ss" 형태로 반환.
	 * @return
	 */
	public static String getUtcSysdate() {
		ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));
		return time.format(JSON_DATE_TIME_FORMATTER);
	}

	/**
	 * 현재 시간을 JSON_DATE_TIME_FORMATTER 형식으로 출력함.
	 * 
	 * @return
	 */
	public static String getLocalSysdate() {
		
		return LocalDateTime.now().format(JSON_DATE_TIME_FORMATTER);
	}
}
