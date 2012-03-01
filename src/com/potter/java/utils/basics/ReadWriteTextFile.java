package com.potter.java.utils.basics;

import java.io.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ReadWriteTextFile {

	Logger logger = Logger.getLogger(ReadWriteTextFile.class);
	String fileName;
	String encoding;
	StringBuilder content;
	
	ReadWriteTextFile(String aFileName){
	    this.fileName = aFileName;
	}
	ReadWriteTextFile(String aFileName,String aEncoding){
		this.fileName = aFileName;
		this.encoding = aEncoding;
	}
	
	void write() throws IOException  {
	    logger.trace("Writing to file named " + fileName + ". Encoding: " + encoding);
	    Writer out;
	    if(encoding != null){
	    	out = new OutputStreamWriter(new FileOutputStream(fileName), encoding);
	    }else{
	    	out = new OutputStreamWriter(new FileOutputStream(fileName));
	    }
	    try {
	      out.write(content.toString());
	    }
	    finally {
	      out.close();
	    }
	  }
	
	void read() throws IOException {
		logger.trace("Reading from file.");
		content = new StringBuilder();
	    String NL = System.getProperty("line.separator");
	    Scanner scanner;
	    if(encoding != null){
	    	scanner = new Scanner(new FileInputStream(fileName), encoding);
	    }else{
	    	scanner = new Scanner(new FileInputStream(fileName));
	    }
	    try {
	      while (scanner.hasNextLine()){
	        content.append(scanner.nextLine() + NL);
	      }
	    }
	    finally{
	      scanner.close();
	    }
	    logger.trace("Text read in: " + content);
	  }
}
