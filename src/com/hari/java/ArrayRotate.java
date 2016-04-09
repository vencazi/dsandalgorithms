package com.hari.java;
import com.hari.utils.IOUtils;

public class ArrayRotate {

	public static void main(String[] args) {
		System.out.print("Enter array seperated by comma : ");
		String arr = IOUtils.readString();
		String[] array = arr.split(",");
		System.out.print("Enter start number : ");
		String[] newArray = new String[array.length];
		System.out.print("Abt to rotate the array : ");
		int len = array.length;
		int k = IOUtils.readInt();
		System.arraycopy(array, k, newArray, 0, (len-k));
		System.arraycopy(array, 0, newArray, (len-k), k);
		for(String st : newArray) {
			System.out.println(st);
		}
	}
	
}