package com.potter.java.utils.basics;

import java.lang.reflect.Array;
import java.util.Date;

public class HashCodeUtil {
	private static final int prime = 41;
	
	public static int hash(Object aThis){
		return hash(prime,aThis);
	}
	
	public static int hash(int aSeed, Object aThis){
		int result = aSeed;
	    if ( aThis == null) {
	      result = hash(result, 0);
	    }
	    else if ( !aThis.getClass().isArray() ) {
	      result = hash(result, aThis.hashCode());
	    }
	    else {
	      int length = Array.getLength(aThis);
	      for ( int idx = 0; idx < length; ++idx ) {
	        Object item = Array.get(aThis, idx);
	        result = hash(result, item);
	      }
	    }
	    return result;
	}
	
	  public static int hash( int aSeed, boolean aBoolean ) {
	    return firstTerm( aSeed ) + ( aBoolean ? 1 : 0 );
	  }

	  public static int hash( int aSeed, char aChar ) {
	    return firstTerm( aSeed ) + (int)aChar;
	  }

	  public static int hash( int aSeed , int aInt ) {
	    return firstTerm( aSeed ) + aInt;
	  }

	  public static int hash( int aSeed , long aLong ) {
	    return firstTerm(aSeed)  + (int)( aLong ^ (aLong >>> 32) );
	  }

	  public static int hash( int aSeed , float aFloat ) {
	    return hash( aSeed, Float.floatToIntBits(aFloat) );
	  }

	  public static int hash( int aSeed , double aDouble ) {
	    return hash( aSeed, Double.doubleToLongBits(aDouble) );
	  }
	  
	  private static int firstTerm( int aSeed ){
		    return prime * aSeed;
	  }
	
	  public static void main(String[] args){
		  Object[] gonnaGetHashed = {new Date(), "temp string!", new Integer(42), new Double(1.01), new Long(42), new Float(1.22)};
		  hash(gonnaGetHashed);
		  hash(23, gonnaGetHashed);
	  }
	  
}
