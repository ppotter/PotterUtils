package com.potter.java.sample.sort;

public class ComparableObject implements Comparable<ComparableObject>{
	private int key;
	private String name;
	private double nonImportantInformation;
	
	@Override
	public int compareTo(ComparableObject that) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this == that) return EQUAL;
	    
	    if(this.getKey() < that.getKey())return BEFORE;
	    if(this.getKey() > that.getKey())return AFTER;
	    
	    int comparison = this.getName().compareTo(that.getName());
	    if(comparison != EQUAL) return comparison;
	    
		return EQUAL;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nonImportantInformation
	 */
	public double getNonImportantInformation() {
		return nonImportantInformation;
	}

	/**
	 * @param nonImportantInformation the nonImportantInformation to set
	 */
	public void setNonImportantInformation(double nonImportantInformation) {
		this.nonImportantInformation = nonImportantInformation;
	}

}
