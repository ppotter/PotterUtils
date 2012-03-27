package com.potter.java.sample.sort;

/**
 * Source: http://www.vogella.de/articles/JavaAlgorithmsMergesort/article.html
 *
 */

public class Merge {

	
	public static void sort(int[] nums){
		mergeSort(nums, 0, nums.length-1);
	}
	
	// Function call using a divide and conquer mentality breaking the data into 1/2 portions 
	// recursively.
	public static void mergeSort(int[] nums, int low, int high) {
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (low + high) / 2;
			// Sort the left side of the array
			mergeSort(nums, low, middle);
			// Sort the right side of the array
			mergeSort(nums, middle + 1, high);
			// Combine them both
			merge(nums, low, middle, high);
		}
	}

	public static void merge(int nums[], int low, int middle, int high) {
		int[] temp = new int[nums.length];
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			temp[i] = nums[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (temp[i] <= temp[j]) {
				nums[k] = temp[i];
				i++;
			} else {
				nums[k] = temp[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			nums[k] = temp[i];
			k++;
			i++;
		}

	}
	
	public static void main(String[] args){
		int[] nums = {10, 3, 5, 2, 8, 6, 4, 9, 7, 1};
		sort(nums);
		for(int i : nums){
			System.out.println(i);
		}
	}
}
