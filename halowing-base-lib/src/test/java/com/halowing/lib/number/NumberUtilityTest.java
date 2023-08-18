package com.halowing.lib.number;

import java.math.RoundingMode;
import java.text.NumberFormat;

import com.halowing.lib.Console;

public class NumberUtilityTest {

	public static void main(String[] args) {
		test5();

	}

	private static void test5() {
		
		Console.log(NumberUtility.toRoundedString("1255", 0));
		
	}

	private static void test4() {
		Float f = NumberUtility.round(1255.3456f, 3);
		Console.log(f);
	}

	private static void test3() {
		
		double d = Math.floor(-123.123d);
		
		Console.log("floor = {}", d);
		
	}

	private static void test2() {
		
		int floor = Math.floorDiv(26, 10);
		Console.log("{}",floor);
	}

	private static void test1() {
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setRoundingMode(RoundingMode.CEILING);
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(3);
		String str = nf.format(123456.7899);
		
		Console.log(str);
	}

}
