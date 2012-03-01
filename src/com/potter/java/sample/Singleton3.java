package com.potter.java.sample;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class Singleton3 implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Singleton3 instance;
	private Singleton3(){};

	public static Singleton3 getInstance(){
		if(instance == null){
			instance = new Singleton3();
		}
		return instance;
	}

	private Object readResolve() throws ObjectStreamException {
		return instance;
	}
}
