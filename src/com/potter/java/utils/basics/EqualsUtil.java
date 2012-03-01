package com.potter.java.utils.basics;

public final class EqualsUtil {
	
	public static Boolean quickEqual(Object aThis, Object aThat){
		if(aThis != null && aThat == null) return false;
		if(aThis == aThat) return true;
		if(aThis.getClass() != aThat.getClass()) return false;
		return null;
	}
	
	public static boolean allEqual(Object[] aThis, Object[] aThat){
		if(aThis.length != aThat.length) return false;
		
		for(int i = 0; i < aThis.length; i++){
			if(!aThis[i].equals(aThat[i])) return false;
		}
		
		return true;
	}
	
}
