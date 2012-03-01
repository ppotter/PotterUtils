package com.potter.java.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.log4j.Logger;

import com.potter.java.utils.basics.ReadWriteSerializable;

public class CSV {
	
	private LinkedHashMap<Integer, String> headerInfo;
	private ArrayList<HashMap<String, String>> content;
	private int columnNumber = 0;
	
	Logger logger = Logger.getLogger(CSV.class);

	
	public CSV(ArrayList<HashMap<String, String>> content){
		this.content = new ArrayList<HashMap<String,String>>(content);
		this.headerInfo = scanContentForHeaderInfo(content);
	}
	
	public CSV(CSV csv){
		this.content = new ArrayList<HashMap<String,String>>(csv.getContent());
		this.headerInfo = scanContentForHeaderInfo(content);
	}
	
	private LinkedHashMap<Integer,String> scanContentForHeaderInfo(ArrayList<HashMap<String, String>> content){
		LinkedHashMap<Integer,String> newHeaderInfo = new LinkedHashMap<Integer,String>();
		for(HashMap<String,String> row : content){
			for(String key : row.keySet()){
				if(!newHeaderInfo.containsValue(key)){
					newHeaderInfo.put(new Integer(columnNumber), key);
					columnNumber++;
				}
			}
		}
		return newHeaderInfo;
	}
	
	private HashMap<Integer,String> scanRowForheaderInfo(HashMap<String,String> row){
		LinkedHashMap<Integer,String> newHeaderInfo = new LinkedHashMap<Integer,String>();
		for(String key : row.keySet()){
			if(!headerInfo.containsValue(key)){
				newHeaderInfo.put(new Integer(columnNumber), key);
				columnNumber++;
			}
		}
		return newHeaderInfo;
	}
	
	

	public boolean addColumn(String column){
		if(!headerInfo.containsValue(column)){
			headerInfo.put(new Integer(columnNumber), column);
			
			if(headerInfo.containsValue(column)){
				columnNumber++;
				return true;
			}
		}
		return false;
	}
	
	public boolean addRow(HashMap<String, String> row){
		if(content.add(row)){
			headerInfo.putAll(scanRowForheaderInfo(row));
			return true;
		}
		return false;
	}
	
	public boolean addRow(ArrayList<String> row){
		int n = 0;
		HashMap<String,String> map = new HashMap<String,String>();
		for(String value : row){
			map.put(headerInfo.get(new Integer(n)), value);
			n++;
		}
		return addRow(map);
	}
	
	public boolean addRow(String[] row){
		int n = 0;
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		for(String value : row){
			map.put(headerInfo.get(new Integer(n)), value);
			n++;
		}
		return addRow(map);
	}

	public boolean removeRow(HashMap<String, String> row){
		return content.remove(row);
	}
	
	
	public HashMap<Integer, String> getHeaderInfo() {
		return headerInfo;
	}

	public ArrayList<HashMap<String, String>> getContent() {
		return content;
	}

	
	
//	public CSV(){
//		headerInfo = new LinkedHashMap<Integer, String>();
//		content = new ArrayList<HashMap<String, String>>();
//	}
	
//	public void setHeaderInfo(LinkedHashMap<Integer, String> headerInfo) {
//		this.headerInfo = headerInfo;
//	}


//	public void setContentScanForHeader(ArrayList<HashMap<String, String>> content) {
//		this.content = content;
//		this.headerInfo = scanContentForHeaderInfo(content);
//	}
	
//	public void setContent(ArrayList<HashMap<String, String>> content) {
//		this.content = content;
//	}

}
