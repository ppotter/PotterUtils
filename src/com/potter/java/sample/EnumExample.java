package com.potter.java.sample;

public enum EnumExample {
	TRUE(Boolean.TRUE),
	FALSE(Boolean.FALSE),
	NULL(null);
	
	private EnumExample(Boolean bool){
		value = bool;
	}
	private Boolean value;
	
	public boolean equals(Boolean that){
		if(that == null && this.value == null) return true;
		return(this.equals(that.booleanValue()));
	}
	
	public boolean equals(boolean that){
		return (this.value.booleanValue() == that);
	}
	
	public boolean equals(EnumExample that){
		if(this == that) return true;
		if(this.equals(that.value)) return true;
		return false;
	}
}
