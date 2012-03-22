package com.potter.java.sample.staticSample;

/*
 * Example from: http://stackoverflow.com/questions/3584113/java-static-class
 * @author: Colin Hebert
 * 
 * Using this for self documentation purposes and reference material.
 */

public class OutterClass {
	public static class StaticNestedClass{
	}

	public class InnerClass{
	}

	public InnerClass getAnInnerClass(){
		return new InnerClass();
	}

	//This method doesn't work
//	public static InnerClass getAnInnerClassStatically(){
//		return new InnerClass();
//	}

	class OtherClass{
	    //Use of a static nested class:
	    private OutterClass.StaticNestedClass staticNestedClass = new OutterClass.StaticNestedClass();

	    //Doesn't work
	    private OutterClass.InnerClass innerClass = new OutterClass.InnerClass();

	    //Use of an inner class:
	    private OutterClass outterclass= new OutterClass();
	    private OutterClass.InnerClass innerClass2 = outterclass.getAnInnerClass();
	    private OutterClass.InnerClass innerClass3 = outterclass.new InnerClass();
	}

}
