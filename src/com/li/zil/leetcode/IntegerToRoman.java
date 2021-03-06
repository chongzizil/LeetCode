package com.li.zil.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Zil on 2014/7/24.
 */
public class IntegerToRoman {
	// A pretty cool solution, learned from others
	private static Map<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();
	static {
		numToRoman.put(1000, "M");
		numToRoman.put(900, "CM");
		numToRoman.put(500, "D");
		numToRoman.put(400, "CD");
		numToRoman.put(100, "C");
		numToRoman.put(90, "XC");
		numToRoman.put(50, "L");
		numToRoman.put(40, "XL");
		numToRoman.put(10, "X");
		numToRoman.put(9, "IX");
		numToRoman.put(5, "V");
		numToRoman.put(4, "IV");
		numToRoman.put(1, "I");
	}

	public static String intToRoman(int num) {
		for (Integer i : numToRoman.keySet()) {
			if (num >= i) {
				return numToRoman.get(i) + intToRoman(num - i);
			}
		}
		return "";
	}
}
