package com.hari.java.sort;

import com.hari.utils.IOUtils;

/**
 * Merge sort implementation. The focus here is mainly on the 
 * merge sort algorithm and less on efficient java programming.
 * 
 * @author venkat
 *
 */
public class MergeSort<T> implements ISort<T> {

	private T[] array;
	
	public MergeSort(T[] array) {
		this.array = array;
	}
	
	public T[] getArray() {
		return array;
	}
	
	public void setArray(T[] array) {
		this.array = array;
	}

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
		ISort<Integer> sort =  new MergeSort(intArr);
		System.out.println("UnSorted Array");
		IOUtils.printArray(sort.getArray());
		sort.doSort();
		System.out.println("Sorted Array");
		IOUtils.printArray(sort.getArray());
	}

	
	public void doSort() {
		divide(array, 0, array.length-1);
	}

	
	/**
	 * This method recursively divides the input array into 2 half till
	 * it reaches to a single element in the array.
	 * Thereafter it invokes the merge method that will then merge the two
	 * sorted arrays into a single sorted array.
	 * 
	 * @param arr
	 * @param lo
	 * @param hi
	 */
	public void divide(T[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo+hi)/2;
			divide(arr, lo, mid);
			divide(arr, mid+1, hi);
			merge((Integer[]) arr, lo, mid, hi);
			IOUtils.printArray(arr);
		} else {
			return;
		}
	}
	
	/**
	 * This method merges the two sorted arrays into one.
	 * 
	 * @param arr
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public void merge(Integer[] arr, int lo, int mid, int hi) {
		int a=lo;
		int b=mid;
		
		int x=mid+1;
		int y=hi;
		
		int[] tempArray = new int[hi-lo+1];
		
		int ind = 0;
		while(a<=b && x<=y) {
			if (arr[a] <= arr[x]) {
				tempArray[ind] = arr[a];
				a++;
			} else {
				tempArray[ind] = arr[x];
				x++;
			}
			ind++;
		}
		while (a<=b) {
			tempArray[ind] = arr[a];
			a++;
			ind++;
		}
		while (x<=y) {
			tempArray[ind] = arr[x];
			x++;
			ind++;
		}
		int tempInd = lo;
		for(int index=0; index<tempArray.length; index++) {
			arr[tempInd] = tempArray[index];
			tempInd = tempInd + 1;
		}
	}
}
