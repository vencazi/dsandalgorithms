package com.hari.java.mergeleet;

import java.util.HashMap;
import java.util.Map;

import com.hari.utils.IOUtils;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * For example:
 * 
 * Input: numbers={2, 7, 11, 15}, 
 * target=9 
 * Output: index1=1, index2=2
 * 
 * @author venkat
 *
 */

public class TwoSum {

	public static void main(String[] args) {
		System.out.print("Input String Array : ");
		String inputStr = IOUtils.readString();
		System.out.print("Input target : ");
		int target = Integer.parseInt(IOUtils.readString());
		String[] inputStrArray = inputStr.split(",");
		int[] intArray = IOUtils.getIntArray(inputStrArray);
		int[] result = findSum(intArray, target);
		if (result != null) {
			System.out.println("The indexes are ==> " + result[0] + " and " + result[1]);
		} else {
			System.out.println("There are no summing numbersO");
		}
	}
	
	public static int[] findSum(int[] inputArray, int target) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = null;
		for(int ind=0; ind<inputArray.length; ind++) {
			if (map.containsKey(inputArray[ind])) {
				result = new int[2];
				result[0] = map.get(inputArray[ind]) + 1;
				result[1] = ind + 1;
				break;
			} else {
				map.put(target - inputArray[ind], ind);
			}
		}
		return result;
	}
	
	
}
