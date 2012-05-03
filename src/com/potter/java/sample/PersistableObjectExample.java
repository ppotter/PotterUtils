package com.potter.java.sample;

import hirondelle.web4j.model.Check;
import hirondelle.web4j.model.ModelUtil;
import static hirondelle.web4j.util.Consts.FAILS;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Savepoint;
import java.util.Date;

import javax.management.InvalidAttributeValueException;

import com.potter.java.utils.basics.EqualsUtil;
import com.potter.java.utils.basics.HashCodeUtil;

public class PersistableObjectExample implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	protected StringBuilder fStringBuilder;
	protected String fString;
	protected Character fCharacter;
	protected Date fDate;
	protected Long fLong;
	protected Integer fInteger;
	protected Short fShort;
	protected Double fDouble;
	protected Float fFloat;
	
	private int hashcode;
	
	/**
	 * full constructor for persistable object.
	 * @param aString
	 * @param aCharacter
	 * @param aDate
	 * @param aLong
	 * @param aInteger
	 * @param aShort
	 * @param aDouble
	 * @param aFloat
	 * @param aCalendar
	 */
	public PersistableObjectExample(StringBuilder fStringBuilder, String aString, Character aCharacter,
			Date aDate, Long aLong, Integer aInteger, Short aShort,
			Double aDouble, Float aFloat) {
		super();
		fString = aString;
		fCharacter = aCharacter;
		fDate = aDate;
		fLong = aLong;
		fInteger = aInteger;
		fShort = aShort;
		fDouble = aDouble;
		fFloat = aFloat;
	}
	
	/**
	 * required fields constructor for persistable object.
	 * @param aString
	 * @param aDate
	 * @param aInteger
	 * @param aDouble
	 */
	public PersistableObjectExample(String aString,
			Date aDate, Integer aInteger,
			Double aDouble) {
		super();
		fString = aString;
		fDate = aDate;
		fInteger = aInteger;
		fDouble = aDouble;
	}
	
	private Object[] getSignificateFields(){
		return (new Object[]{fString,fDate,fInteger,fDouble});
	}
	
	private Object[] getAllFields(){
		Object[] result = new Object[]{};
		return (new Object[]{fString,fDate,fInteger,fDouble});
	}

	@Override
	public int hashCode() {
		if(hashcode == 0){
			hashcode = HashCodeUtil.hash(this); 
		}
		return hashcode;
	}

	@Override 
	public boolean equals(Object aThat) {
		Boolean result = EqualsUtil.quickEqual(this, aThat);
		if(result == null){
			PersistableObjectExample that = (PersistableObjectExample)aThat;
			result = EqualsUtil.allEqual(this.getSignificateFields(), that.getSignificateFields());
		}
		return result;
	}
	
	/*
	  * To disable clone in a subclass.
	  @Override public final Object clone() throws CloneNotSupportedException {
	    throw new CloneNotSupportedException();
	  }
	 */
	@Override 
	public PersistableObjectExample clone() throws CloneNotSupportedException{
		//handles immutable fields.
		PersistableObjectExample result = (PersistableObjectExample)super.clone();
		
		//manually handle mutable fields.
		if(this.getfStringBuilder() != null)result.setfStringBuilder(new StringBuilder(this.getfStringBuilder()));
		result.setfDate(new Date(this.getfDate().getTime()));
		return result;
	}

	@Override 
	public String toString() {
		return ModelUtil.toStringFor(this);
	}
	
	public String toStringDebug(){
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" {");
		result.append(newLine);

		Field[] fields = this.getClass().getDeclaredFields();

		for (Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append("= ");
				//requires access to private field:
				result.append(field.get(this));
			}
			catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}
	
	public void validateState() throws IllegalArgumentException{
		StringBuilder message = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		//required fields.
		if(FAILS == Check.required(fString)){
			message.append("fString is required.");
			message.append(newLine);
		}
		if(FAILS == Check.required(fDate)){
			message.append("fDate is required.");
			message.append(newLine);
		}
		if(FAILS == Check.required(fInteger, Check.min(0))){
			message.append("fInteger is required.");
			message.append(newLine);
		}
		if(FAILS == Check.required(fDouble)){
			message.append("fDouble is required.");
			message.append(newLine);
		}
		if(fInteger.intValue() < 0){
			message.append("fInteger must be non-negative.");
			message.append(newLine);
		}
		if(fDate.after(new Date())){
			message.append("fDate cannot be in the future.");
			message.append(newLine);
		}
		if(!message.toString().isEmpty()){
			throw new IllegalArgumentException(message.toString());
		}
	}

	public StringBuilder getfStringBuilder() {
		return fStringBuilder;
	}

	public void setfStringBuilder(StringBuilder fStringBuilder) {
		this.fStringBuilder = fStringBuilder;
	}

	public String getfString() {
		return fString;
	}

	public void setfString(String fString) {
		this.fString = fString;
	}

	public Character getfCharacter() {
		return fCharacter;
	}

	public void setfCharacter(Character fCharacter) {
		this.fCharacter = fCharacter;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	public Long getfLong() {
		return fLong;
	}

	public void setfLong(Long fLong) {
		this.fLong = fLong;
	}

	public Integer getfInteger() {
		return fInteger;
	}

	public void setfInteger(Integer fInteger) {
		this.fInteger = fInteger;
	}

	public Short getfShort() {
		return fShort;
	}

	public void setfShort(Short fShort) {
		this.fShort = fShort;
	}

	public Double getfDouble() {
		return fDouble;
	}

	public void setfDouble(Double fDouble) {
		this.fDouble = fDouble;
	}

	public Float getfFloat() {
		return fFloat;
	}

	public void setfFloat(Float fFloat) {
		this.fFloat = fFloat;
	}

}
