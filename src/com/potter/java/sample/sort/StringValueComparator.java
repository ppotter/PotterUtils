package com.potter.java.sample.sort;

import java.util.Comparator;

public class StringValueComparator implements Comparator<String> {

	public Integer sumCharacters(String s){
		int result = 0;
		for(char c : s.toCharArray()){
			result += c;
		}
		return new Integer(result);
	}
	
	@Override
	public int compare(String aThis, String aThat) {
		return sumCharacters(aThis).compareTo(sumCharacters(aThat));
	}

}
