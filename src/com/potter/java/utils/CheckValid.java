package com.potter.java.utils;

import static hirondelle.web4j.util.Consts.FAILS;
import static hirondelle.web4j.util.Consts.PASSES;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import hirondelle.web4j.model.Check;
import hirondelle.web4j.model.Code;
import hirondelle.web4j.model.Decimal;
import hirondelle.web4j.model.Id;
import hirondelle.web4j.model.Validator;
import hirondelle.web4j.security.SafeText;
import hirondelle.web4j.util.Util;

public class CheckValid extends Check {

	public static Validator isPositive(Boolean... aPredicates){
		class isPositive implements Validator{
			public boolean isValid(Object aObject) {
				Long john = new Long(getValueAsLong(aObject));
				if(john.longValue() > 0) return true;
				return false;
			};
		}
		return new isPositive();
	}
	
	public static Validator isNegative(Boolean... aPredicates){
		class isNegative implements Validator{
			public boolean isValid(Object aObject) {
				Long john = new Long(getValueAsLong(aObject));
				if(john.longValue() < 0) return true;
				return false;
			};
		}
		return new isNegative();
	}
	
	/*
	 * private code from hirondelle.web4j.model.Check;
	 * potentially recompile check with these methods as protected.
	 */
	private static long getValueAsLong(Object aObject){
	    long result = 0;
	    if ( aObject instanceof Integer){
	      Integer value = (Integer)aObject;
	      result = value.intValue();
	    }
	    else if (aObject instanceof Long) {
	      Long value = (Long)aObject;
	      result = value.longValue();
	    }
	    else if (aObject instanceof String){
	      String text = (String)aObject;
	      if ( Util.textHasContent(text) ) {
	        result = text.trim().length();
	      }
	    }
	    else if (aObject instanceof Id){
	      Id id = (Id)aObject;
	      if ( Util.textHasContent(id.toString()) ) {
	        result = id.toString().trim().length();
	      }
	    }
	    else if (aObject instanceof SafeText){
	      SafeText text = (SafeText)aObject;
	      if ( Util.textHasContent(text.getRawString()) ) {
	        result = text.getRawString().trim().length();
	      }
	    }
	    else if (aObject instanceof Code){
	      Code code = (Code)aObject;
	      if ( Util.textHasContent(code.getText()) ) {
	        result = code.getText().getRawString().trim().length();
	      }
	    }
	    else if (aObject instanceof Collection) {
	      Collection collection = (Collection)aObject;
	      result = collection.size();
	    }
	    else if (aObject instanceof Map) {
	      Map map = (Map)aObject;
	      result = map.size();
	    }
	    else if (aObject instanceof Date) {
	      Date date = (Date)aObject;
	      result = date.getTime(); 
	    }
	    else if (aObject instanceof Calendar){
	      Calendar calendar = (Calendar)aObject;
	      result = calendar.getTimeInMillis();
	    }
	    else {
	      String message = "Unexpected type of Object: " + aObject.getClass().getName();
//	      fLogger.severe(message);
	      throw new AssertionError(message);
	    }
	    return result;
	  }
	  
	  private static boolean isText(Object aObject){
	    return (aObject instanceof String) || (aObject instanceof SafeText);
	  }
	  
	  private static String getText(Object aObject){
	    String result = null;
	    if ( aObject instanceof String ){
	      String text = (String) aObject;
	      result = text.toString();
	    }
	    else if (aObject instanceof SafeText ){
	      SafeText text = (SafeText)aObject;
	      result = text.getRawString();
	    }
	    return result;
	  }
	  
	  /** aObject must be a BigDecimal or a Money object.  */
	  private static BigDecimal extractNumber(Object aObject){
	    BigDecimal result = null;
	    if( aObject instanceof BigDecimal){
	      result = (BigDecimal)aObject;
	    }
	    else if (aObject instanceof Decimal) {
	      Decimal decimal = (Decimal)aObject;
	      result = decimal.getAmount();
	    }
	    else {
	      throw new IllegalArgumentException("Unexpected class: " + aObject.getClass());
	    }
	    return result;
	  }
}
