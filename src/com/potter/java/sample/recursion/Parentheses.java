package com.potter.java.sample.recursion;

/*
 * algorithm to print all valid (e g , properly opened and closed) 
 * combinations of n-pairs of parentheses 
 */

public class Parentheses {

	public static String parenthesesStarter(int n){
		StringBuilder results = new StringBuilder();
		if(n > 1){

			for(int j = 0; j < n; j++){
				results.append(parentheses(1));
			}
			results.append(",");
		}
		if(n > 2){
			for(int i = n-1; i > 0; i--){
				results.append(parentheses(i));
				results.append(parentheses(n-i));
				results.append(",");
			}
		}
		results.append(parentheses(n));
		return results.toString();
	}
	
	public static String parentheses(int n){
		if(n <= 1){
			return "()";
		}
		return "(" + parentheses(n-1) + ")";
	}
	
	public static void main(String[] args){
		System.out.println(parenthesesStarter(3));
	}
	
}
