package com.potter.java.sample.recursion;

/*
 * Class designed to output all the possible valid pairs of Parentheses. 
 */

public class Parentheses {
	static void parentheses(int open, int close, String result) {
		if (open == 0 && close == 0) {
			//recursion has reached the end of a pair(hit the maximum number of parentheses
			//it can use, So output the built string.
			System.out.println(result);
		}
		//if you have more open parentheses to use then use them, decrement the amount of
		// available openers and increment the amount of available closers.
		if (open > 0) {
			parentheses(open-1, close+1, result + "(");
		}
		//if you have more close parentheses available then use them and decrement that amount.
		if (close > 0) {
			parentheses(open, close-1, result + ")");
		}
	}
	public static void main(String[] args) {
		parentheses(4, 0, "");
	}
}
