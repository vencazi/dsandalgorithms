package com.hari.java.sort;

import java.util.Arrays;

import com.hari.utils.IOUtils;

/**
 * This class retrieves the kth largest element from the array.
 * @author venkat
 *
 */

public class KthLargest {

	public static void main(String[] args) {
		System.out.print("Enter Array String seperated by comma : ");
		String str = IOUtils.readString();
		String[] arr = str.split(",");
		Integer[] intArr = new Integer[arr.length];
		int ind = 0;
		for(String s:arr) {
			intArr[ind] = Integer.parseInt(s);
			ind++;
		}
		System.out.print("Enter Kth value : ");
		int kth = IOUtils.readInt();
		Arrays.sort(intArr);
		if (kth <= arr.length) {
			System.out.println("Kth largest value in the array is ==> " + intArr[arr.length-kth]);
		} else {
			System.out.println("Kth value is > the size of the array");
		}
	}
	
}
