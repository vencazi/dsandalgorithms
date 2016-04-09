package com.hari.java;
import com.hari.utils.IOUtils;

public class ArrayRotateEfficient {

	public static void main(String[] args) {
		System.out.print("Enter array as comma seperted : ");
		String arr = IOUtils.readString();
		String[] array = arr.split(",");
		System.out.print("Enter starting index : ");
		int ind = IOUtils.readInt();
		int len = array.length;
		reverse(array, 0, (len-ind)-1);
		//display(array);
		reverse(array, (len-ind), len-1);
		//display(array);
		reverse(array, 0, len-1);
		display(array);
	}
	
	public static void reverse(String[] array, int startInd, int endInd) {
		while (startInd <= endInd) {
			String t = array[startInd];
			array[startInd] = array[endInd];
			array[endInd] = t;
			startInd++;
			endInd--;
		}
	}
	
	public static void display(String[] array) {
		for(String arr : array) {
			System.out.println(arr);
		}
	}
	
}
