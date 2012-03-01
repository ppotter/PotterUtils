package com.potter.java.utils.basics;

import java.io.*;
import org.apache.log4j.Logger;

public class ReadWriteSerializable {
	Logger logger = Logger.getLogger(ReadWriteSerializable.class);
	Object object;
	String fileName = "serializable.ser";
	
	/**
	 * constructor for default serializable.
	 * @param object
	 */
	public ReadWriteSerializable(Object object){
		this.object = object;
	}
	/**
	 * constructor for parameterized serializable.
	 * @param object
	 * @param fileName
	 */
	public ReadWriteSerializable(Object object,String fileName){
		this.object = object;
		this.fileName = fileName;
	}
	
	/**
	 * constructor for typical serializable reader
	 * @param fileName
	 */
	public ReadWriteSerializable(String fileName){
		this.fileName = fileName;
	}
	
	public void write() throws IOException{
			OutputStream file = new FileOutputStream(fileName);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			try{
				output.writeObject(object);
			}
			finally{
				output.close();
			}
	}

	public Object read() throws ClassNotFoundException, IOException{
			InputStream file = new FileInputStream(fileName);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream (buffer);
			try{
				object = input.readObject();
			}
			finally{
				input.close();
			}
		return object;
	}
}
