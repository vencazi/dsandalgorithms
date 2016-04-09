package com.hari.java;

import java.util.HashMap;
import java.util.Map;

import com.hari.utils.IOUtils;

public class Isomorphic {

	public static void main(String[] str) {

		System.out.print("Enter String 1 : ");
		String str1 = IOUtils.readString();
		System.out.print("Enter String 2 : ");
		String str2 = IOUtils.readString();

		boolean flag = isIsomorphic(str1, str2);
		System.out.println("Is Isomorphic : " + flag);

	}

	public static boolean isIsomorphic(String str1, String str2) {

		if (str1.trim().length() != str2.trim().length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int ind = 0; ind < str1.length(); ind++) {
			map.put(str1.charAt(ind), str2.charAt(ind));
		}
		
		String str3 = "";
		
		for (int ind = 0; ind < str1.length(); ind++) {
			str3 = str3 + map.get(str1.charAt(ind));
		}
		
		System.out.println(str3);
		
		if (str3.equals(str2)) {
			return true;
		}
		
		

		return false;
	}

}
