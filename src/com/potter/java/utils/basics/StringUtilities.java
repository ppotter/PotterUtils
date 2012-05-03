package com.potter.java.utils.basics;

import java.util.Arrays;

public class StringUtilities {
	
	/**
	 * Wraps a String in provided strings.
	 * 
	 * Will return null if s is null.
	 * Will not attach leftWrapper or rightWrapper should they be null.
	 * @param s String to be Wrapped.
	 * @param leftWrapper left bound wrapper.
	 * @param rightWrapper right bound wrapper.
	 * @return s surrounded by leftWrapper and rightWrapper.
	 */
	public static String wrap(String s, String leftWrapper, String rightWrapper){
		if(s == null) return null;
		if(leftWrapper == null && rightWrapper == null) return s;
		if(leftWrapper == null) leftWrapper = "";
		if(rightWrapper == null) rightWrapper = "";
		return leftWrapper + s + rightWrapper;
	}

	public static String wrap(String s, String wrapper){
		return wrap(s, wrapper, wrapper);
	}
	
	public static String wrapWithBraces(String s){
		return wrap(s, "{", "}");
	}
	
	public static String wrapWithBrackets(String s){
		return wrap(s, "[", "]");
	}
	
	public static String wrapWithParentheses(String s){
		return wrap(s, "(", ")");
	}
	
	public static String reverse(String s){
		StringBuilder result = new StringBuilder(s);
		return result.reverse().toString();
	}
	
	public static StringBuilder prepend(StringBuilder sBuilder, String s){
		return sBuilder.insert(0, s);
	}
	
	public static StringBuilder clone(StringBuilder s){
		return new StringBuilder(s.toString());
	}
	
	public static boolean isNullEmpty(String s){
		return s == null || s.equals("");
	}
	
	public static String sortCharacters(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static boolean isAnagram(String aThis, String aThat){
		return sortCharacters(aThis).equalsIgnoreCase(sortCharacters(aThat));
	}
	
	public static boolean isPalindrome(String s){
		for(int i = 0; i < s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isAllUpperCase(String s){
		return s.equals(s.toUpperCase());
	}
	
	public static boolean isAllLowerCase(String s){
		return s.equals(s.toLowerCase());
	}
	
}
