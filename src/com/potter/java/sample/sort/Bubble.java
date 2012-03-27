package com.potter.java.sample.sort;

public class Bubble {

	
	public static void sort(int[] nums){
		int tempSpace = 0;
		for(int i = 0; i < nums.length-1; i++){
			for(int j = 0; j < nums.length-1; j++){
				if(nums[j] > nums[j+1]){
					tempSpace = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tempSpace;
				}
			}
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
