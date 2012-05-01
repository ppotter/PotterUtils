package com.potter.java.utils.basics;

public class StringUtils {

	public static String wrapWithBraces(String s){
		if(s == null) return null;
		return "{" + s + "}";
	}
	
	public static String wrapWithBrackets(String s){
		if(s == null) return null;
		return "[" + s + "]";
	}
	
	public static String wrapWithParentheses(String s){
		if(s == null) return null;
		return "[" + s + "]";
	}
}
