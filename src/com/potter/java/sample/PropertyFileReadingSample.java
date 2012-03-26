package com.potter.java.sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyFileReadingSample {

	public PropertyFileReadingSample(){}
	
	public Properties getProperties(String file) throws IOException{
		Properties results = new Properties();
		InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream(file));
		results.load(reader);
		return results;
	}
	
	public static void main(String[] args){
		try {
			Properties props = new PropertyFileReadingSample().getProperties("/files/props/test.props");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
