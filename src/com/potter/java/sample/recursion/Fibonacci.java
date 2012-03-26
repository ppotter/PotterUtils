package com.potter.java.sample.recursion;

/*
 * returns the n-th fibonacci number in the fibonacci sequence.
 */

public class Fibonacci {

	public static int fibonacci(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n < 0) return -1;//error state
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args){
		System.out.println(fibonacci(3));
	}
}
