package com.hari.java.sort;

import com.hari.utils.IOUtils;

/**
 * Implementation of QuickSort algorithm.
 * @author venkat
 *
 * @param <T>
 */
public class QuickSort<T> implements ISort<T> {

	public T[] array;
	
	public void doSort() {
		quickSort(array, 0, array.length-1);
	}
	
	public void quickSort(T[] array, int start, int end) {
		if (start > end) {
			return;
		}
		// First partition the array to get the pivot index.
		int pivot = partition((Integer[]) array, start, end);
		// using the partition index, divide the array recursively.
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
	}
	
	public int partition(Integer[] array, int start, int end) {
		Integer pivot = array[end];
		int pivotIndex = start;
		for(int ind=start; ind < end; ind++) {
			if (array[ind] <= pivot) {
				swap(array, ind, pivotIndex);
				pivotIndex++;
			}
		}
		swap(array, pivotIndex, end);
		return pivotIndex;
	}

	public void swap(Integer[] array, int ind, int pivotIndex) {
		Integer temp = array[ind];
		array[ind] = array[pivotIndex];
		array[pivotIndex] = temp;
	}
	
	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public QuickSort(T[] array) {
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
		ISort<Integer> sort =  new QuickSort(intArr);
		System.out.println("UnSorted Array");
		IOUtils.printArray(sort.getArray());
		sort.doSort();
		System.out.println("Sorted Array");
		IOUtils.printArray(sort.getArray());
	}
	
}
