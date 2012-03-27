package com.potter.java.sample.sort;

public class Selection {

	public static void sort(int[] nums){
		// minIndex maintains the index of the minimum value in the unsorted array.
		// minValue is temporary space for switching values in the array.
		int minIndex = 0, minValue = 0;
		// index maintains the current starting index 
		// of the unsorted portion of the array.
		for(int index = 0; index < nums.length; index++){
			// Determine the index of the minimum value
			// in the unsorted portion of the array.
			for(int i = index; i < nums.length; i++){
				if(nums[i] < nums[minIndex]){
					minIndex = i;
				}
			}
			// store the minimum value forlater
			minValue = nums[minIndex];
			// shift all the values left of the minimum index in the unsorted 
			// array to the right one.
			for(int j = minIndex; j > index; j--){
				nums[j] = nums[j-1];
			}
			nums[index] = minValue;
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
