package com.potter.java.utils.type;

public class BoolType extends Object {
	protected boolean bool;
	protected Object type = null;
	
	public BoolType(){};
	public BoolType(Object type){
		this.type = type;
		bool = true;
	}
	
	public BoolType(boolean bool){
		this.bool = bool;
	}
	
	public boolean booleanValue(){
		return bool;
	}
	
	public String type(){
		if(type != null){
			return type.toString();
		}
		return Boolean.toString(bool);
	}
}
