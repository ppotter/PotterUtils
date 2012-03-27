package com.potter.java.sample.sort;

public class Insertion {

	
	public static void sort(int[] nums){
		int j = 0, tempSpace = 0;
		for(int i = 1; i < nums.length; i++){
			tempSpace = nums[i];
			j = i;
			while(j> 0 && nums[j-1] > tempSpace){
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = tempSpace;
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
