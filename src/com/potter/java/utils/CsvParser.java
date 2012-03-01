package com.potter.java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CsvParser {

	/**
	 * headerInfo - HashMap Containing header column of csv
	 * with its corresponding column number.
	 */
	private LinkedHashMap<Integer, String> rawHeaderInfo; 
	
	/**
	 * content - the main content of the csv without the header.
	 */
	private Collection<String> rawContent;
	
	
	/**
	 * Write Variables.
	 */
	
	private BufferedWriter fWriter;
	
	
	
	public CsvParser(){
		
	}
	
	/**
	 * returns an ArrayList of Hashmaps, where each HashMap represents a row
	 * and their data is accessible via calling get(key) where the key is 
	 * the column title for the data of interest. 
	 *  
	 * @param fileName
	 * @return
	 */
	public static ArrayList<HashMap<String, String>> parse(String fileName){
		return parse(new File(fileName));
	}
	
	public static ArrayList<HashMap<String, String>> parse(File file){
		CsvParser csvParser = new CsvParser();
		ArrayList<HashMap<String, String>> csv = new ArrayList<HashMap<String, String>>();
		csvParser.parseCsv(file);
		csv = csvParser.parseContent(csvParser.getHeaderInfo(), csvParser.getContent());
		return csv;
	}
	
	
	public ArrayList<HashMap<String, String>> parseContent(HashMap<Integer,String> header, Collection<String> lines){
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;
		String[] recordsOnLine;
		int col;
		for(String i : lines){
			map = new HashMap<String, String>();
			recordsOnLine = i.split(",");
			col = 0;
			for(String j : recordsOnLine){
				map.put(header.get(new Integer(col)), j);
				col++;
			}
			list.add(map);
		}
		
		return list;
	}
	
	public LinkedHashMap<Integer, String> parseHeader(String line){
		LinkedHashMap<Integer, String> header = new LinkedHashMap<Integer, String>();
		String[] columnsOnLine = line.split(",");
		int i = 0;
		
		for(String str : columnsOnLine){
			header.put(new Integer(i), str);
			i++;
		}
		
		return header;
	}
	
	public void parseCsv(File file) {
		Collection<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			if((line = br.readLine()) != null){
				setHeaderInfo(parseHeader(line));
			}
			
			while ((line = br.readLine()) != null) {
				if(!line.startsWith("#") && !line.trim().isEmpty()){
					lines.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Importing CSV: ");
		printLines(lines);
		System.out.println("\n\n-----------------\n\n");
//		printRecords(lines);
		setContent(lines);
//		setupDevices(lines);
	}
	
	//TODO
	public void writeCSV(CSV csv, File file) throws IOException{
		fWriter = new BufferedWriter(new FileWriter(file));
		writeHeader(csv.getHeaderInfo());
		writeContent(csv);
		fWriter.close();
	}
	
	protected void writeHeader(CSV csv) throws IOException{
		writeHeader(csv.getHeaderInfo());
	}
	
	protected void writeHeader(HashMap<Integer, String> headMap) throws IOException{
		String str = "";
	    for(int i = 0; i < headMap.size(); i++){
	    	str += headMap.get(new Integer(i));
	    	if(i+1 < headMap.size()){
	    		str+= ",";
	    	}
	    }
		fWriter.write(str);
		fWriter.newLine();
	}
	
	
	/**
	 * write content from CSV to file buffer.
	 * 
	 * @param csv
	 * @throws IOException
	 */
	protected void writeContent(CSV csv) throws IOException{
		String str = "";
		int numOfCols = csv.getHeaderInfo().size();
		
		//get each row from the csv content iteratively.
		for(HashMap<String,String> row : csv.getContent()){
			str = "";
			/*
			 * get the value of each entry from row for each column header.
			 * and insert a coma regardless of if there is an entry for that 
			 * header.
			 */
			for(int i = 0; i < numOfCols; i++){
		    	String value = row.get(csv.getHeaderInfo().get(new Integer(i)));
		    	if(value != null){
		    		str += value;
		    	}
		    	if(i+1 < numOfCols){
		    		str += ",";
		    	}
		    }
			fWriter.write(str);
			fWriter.newLine();
		}
	}
	
	public CSV readCSV(String filename) throws IOException{
		return readCSV(new File(filename));
	}
	
	public CSV readCSV(File file) throws IOException{
		Collection<String> lines = new ArrayList<String>();
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
			
		String line;

		if((line = br.readLine()) != null){
			setHeaderInfo(parseHeader(line));
		}

		while ((line = br.readLine()) != null) {
			if(!line.startsWith("#")){
				lines.add(line);
			}
		}
		CSV csv = new CSV(parse(file));
		return csv;
	}
	
	
	private static void printLines(Collection<String> lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}

	public HashMap<Integer, String> getHeaderInfo() {
		return rawHeaderInfo;
	}

	public void setHeaderInfo(LinkedHashMap<Integer, String> headerInfo) {
		this.rawHeaderInfo = headerInfo;
	}

	public Collection<String> getContent() {
		return rawContent;
	}

	public void setContent(Collection<String> content) {
		this.rawContent = content;
	}

	
}
