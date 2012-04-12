package com.potter.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuzzyCompare {
	
	public static boolean equals(Integer aThis, Integer aThat){
		return equals(aThis,aThat, 1);
	}
	
	public static boolean equals(Long aThis, Long aThat){
		return equals(aThis, aThat, 10);
	}
	
	public static boolean equals(Integer aThis, Integer aThat, int variance){
		if(aThis.equals(aThat)) return true;
		int diff = Math.abs(aThis.intValue() - aThat.intValue());
		if(diff <= variance) return true;
		return false;
	}
	
	public static boolean equals(Long aThis, Long aThat, long variance){
		if(aThis.equals(aThat)) return true;
		long diff = Math.abs(aThis.longValue() - aThat.longValue());
		if(diff <= variance) return true;
		return false;
	}
	
	public static boolean equals(Float aThis, Float aThat){
		return equals(aThis,aThat, (float)0.0001);
	}
	
	public static boolean equals(Double aThis, Double aThat){
		return equals(aThis,aThat, 0.0000001);
	}
	
	public static boolean equals(Float aThis, Float aThat, float variance){
		if(aThis.equals(aThat)) return true;
		float diff = Math.abs(aThis.floatValue() - aThat.floatValue());
		if(diff < variance) return true;
		return false;
	}
	
	public static boolean equals(Double aThis, Double aThat, double variance){
		if(aThis.equals(aThat)) return true;
		double diff = Math.abs(aThis.doubleValue() - aThat.doubleValue());
		if(diff < variance) return true;
		return false;
	}
	
	public static boolean equals(String aThis, String aThat){
		Boolean result;
		if((result = nullCheck(aThis,aThat)) != null) return result;
		if(aThis.equals(aThat))return true;
		if(aThis.equalsIgnoreCase(aThat))return true;
		
		String trimedThis = removeWhiteSpace(aThis), trimedThat = removeWhiteSpace(aThat);
		if(trimedThis.equalsIgnoreCase(trimedThat))return true;
		int thisNums = countNumbers(trimedThis), thatNums = countNumbers(trimedThat);
		int thisChars = countCharacters(trimedThis), thatChars = countCharacters(trimedThat);
		if(thisNums > thisChars && thatNums > thatChars){
			if(removeCharacters(trimedThis).equalsIgnoreCase(removeCharacters(trimedThat))){
				return true;
			}
		}
		if(thisNums < thisChars && thatNums < thatChars){
			if(removeNumbers(trimedThis).equalsIgnoreCase(removeNumbers(trimedThat))){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean similar(String aThis, String aThat){
		Boolean result;
		if((result = nullCheck(aThis,aThat)) != null) return result;
		if(aThis.toUpperCase().contains(aThat.toUpperCase())) return true;
		if(aThat.toUpperCase().contains(aThis.toUpperCase())) return true;
		return equals(aThis,aThat);
	}
	
	protected static Boolean nullCheck(String aThis, String aThat){
		if(aThis == null && aThat == null) return true;
		if(aThis == null) return false;
		if(aThat == null) return false;
		return null;
	}
	
	public static String removeWhiteSpace(String s){
		String result = s.replace(" ", "");
		return result.trim();
	}
	
	public static int countNumbers(String s){
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.isDigit(s.toCharArray()[i])){
				result++;
			}
		}
		return result;
	}
	
	public static int countCharacters(String s){
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.isLetter(s.toCharArray()[i])){
				result++;
			}
		}
		return result;
	}
	
	public static String removeNumbers(String s){
		Matcher m = Pattern.compile("\\d").matcher(s);
		return m.replaceAll("");
	}
	
	public static String removeCharacters(String s){
		Matcher m = Pattern.compile("\\D").matcher(s);
		return m.replaceAll("");
	}
}
