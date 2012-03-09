package com.potter.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlReader {
	
	public UrlReader() {

	}
	
	public UrlReader(String proxyHost, String proxyPort){
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
	}
	
	public String readTextFromUrl(String site) throws IOException{
		StringBuilder results = new StringBuilder();
		URL url = new URL(site);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()));

		String line;
		while ((line = in.readLine()) != null){
			results.append(line);
			results.append("\n");
		}
		in.close();
		return results.toString();
	}
	
	public InputStream getStreamFromUrl(String site) throws IOException{
		URL url = new URL(site);
		return url.openStream();
	}

	public static void main(String[] args) throws Exception {
		UrlReader urlReader = new UrlReader("cache1.lexmark.com", "80");
		String results = urlReader.readTextFromUrl("http://www.oracle.com/");
		System.out.println(results);
	}
}
