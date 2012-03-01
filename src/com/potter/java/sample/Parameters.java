package com.potter.java.sample;

import java.awt.Color;

import junit.framework.Assert;


public class Parameters {
	public static boolean nonRequiredParamsTest(String... strings){
		return true;
	}
	
	public static void outputParamsTest(String strings, MutableSample mutable){
		strings = "new string";
		mutable.changeLight();
		return;
	}
	
	public static void main(String[] args){
		Assert.assertTrue(Parameters.nonRequiredParamsTest());
		Assert.assertTrue(Parameters.nonRequiredParamsTest("Test"));
		Assert.assertTrue(Parameters.nonRequiredParamsTest(null));
		String strings = "test";
		Assert.assertTrue("test".equals("test"));
		MutableSample mutable = new MutableSample();
		Color color = mutable.getCurrentLight();
		Assert.assertTrue(strings.equals("test"));
		Assert.assertTrue(mutable.getCurrentLight().equals(color));
		//call a function to change the values of these parameters
		//the string shouldn't change value since its immutable.
		//the mutable object should change state and no longer pass the
		//same equals test.
		outputParamsTest(strings, mutable);
		Assert.assertTrue(strings.equals("test"));
		Assert.assertFalse(mutable.getCurrentLight().equals(color));
	}
}
