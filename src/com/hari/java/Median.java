package com.hari.java;

import com.hari.utils.IOUtils;

/**
 * This class finds the median  between 2 sorted arrays.
 * Uses the comparing median algorithm.
 * @author venkat
 *
 */
public class Median {
	
	public static void main(String[] args) {
		Integer[] arrayA = getInput();
		Integer[] arrayB = getInput();
		process(arrayA, arrayB);
	}

	static void process(Integer[] arrayA, Integer[] arrayB) {
		IOUtils.printArray(arrayA);
		IOUtils.printArray(arrayB);
		int medA = arrayA.length/2;
		int medB = arrayB.length/2;
		
		if (arrayA.length == 1 || arrayB.length == 1) {
			return;
		}
		
		if (arrayA[medA] == arrayB[medB]) {
			return;
		}
		Integer[] tempA = null;
		Integer[] tempB = null;
		if (arrayA[medA] < arrayB[medB]) {
			tempA = new Integer[arrayA.length-medA];
			System.arraycopy(arrayA, medA, tempA, 0, arrayA.length-medA);
			tempB = new Integer[medB];
			System.arraycopy(arrayB, 0, tempB, 0, medB);
		} else {
			tempA = new Integer[medA];
			System.arraycopy(arrayA, 0, tempA, 0, medA);
			tempB = new Integer[arrayB.length-medB];
			System.arraycopy(arrayB, medB, tempB, 0, arrayB.length-medB); 
		}
		process(tempA, tempB);
	}
	
	static Integer[] getInput() {
		System.out.print("Enter Array String seperated by comma : ");
		String str = IOUtils.readString();
		String[] arr = str.split(",");
		Integer[] intArray = new Integer[arr.length];
		int ind = 0;
		for(String s:arr) {
			intArray[ind] = Integer.parseInt(s);
			ind++;
		}
		return intArray;
	}
	
}
