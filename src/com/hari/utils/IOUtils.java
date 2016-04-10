package com.hari.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IOUtils {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String readString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static int readInt() {
		String str;
		try {
			str = br.readLine();
			return Integer.parseInt(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	public static void printArray(Object[] arr) {
		Integer[] intArray = (Integer[]) arr;
		int ind = 0;
		for(int i:intArray) {
			System.out.print(i + ((ind == arr.length-1)?"":"|"));
			ind++;
		}
		System.out.println("\n*********************************");
	}
	
}
