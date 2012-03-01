package com.potter.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.potter.java.utils.CSV;

import junit.framework.TestCase;

public class CSVTest extends TestCase {

	private CSV genericObj;
	private LinkedHashMap<Integer, String> genericHeaderInfo;
	private ArrayList<HashMap<String, String>> genericContent;
	private HashMap<String, String> row;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		int rows = 3;
		int columns = 3;
		
		genericHeaderInfo = new LinkedHashMap<Integer, String>();
		for(int i = 0; i < columns; i++){
			genericHeaderInfo.put(new Integer(i), "column" + i);
		}
		
		genericContent = new ArrayList<HashMap<String,String>>();
		LinkedHashMap<String,String> newRow;
		for(int i = 0; i < rows; i++){
			newRow = new LinkedHashMap<String, String>();
			for(int j = 0; j < genericHeaderInfo.size(); j++){
				newRow.put(genericHeaderInfo.get(new Integer(j)), "row" + i + "column" + j);
			}
			genericContent.add(newRow);
		}
		
		row = new HashMap<String, String>();
		for(int j = 0; j < genericHeaderInfo.size(); j++){
			row.put(genericHeaderInfo.get(new Integer(j)), "newRow column" + j);
		}
	}
	
	@Test
	public void testConstructor(){
		CSV csv = new CSV(genericContent);
		assertEquals(csv.getContent(), genericContent);
	}
	
	@Test
	public void testCopyConstructor(){
		CSV csv = new CSV(genericContent);
		CSV csvCopy = new CSV(csv);
		assertEquals(csvCopy.getContent(),csv.getContent());
		assertEquals(csvCopy.getHeaderInfo(),csv.getHeaderInfo());
	}
	
	@Test
	public void testAddColumn(){
		CSV csv = new CSV(genericContent);
		csv.addColumn("tempColumn");
		assertTrue(csv.getHeaderInfo().containsValue("tempColumn"));
	}
	
	@Test
	public void testAddRowHashmap(){
		CSV csv = new CSV(genericContent);
		csv.addRow(row);
		assertTrue(csv.getContent().contains(row));
	}
	
	@Test
	public void testAddRowString(){
		CSV csv = new CSV(genericContent);
		String[] newRow = {"newRow column0", "newRow column1", "newRow column2"};
		csv.addRow(newRow);
		assertTrue(csv.getContent().contains(row));
	}
	
	@Test
	public void testAddRowArray(){
		CSV csv = new CSV(genericContent);
		ArrayList<String> newRow = new ArrayList<String>();
		newRow.add("newRow column0");
		newRow.add("newRow column1");
		newRow.add("newRow column2");
		csv.addRow(row);
		assertTrue(csv.getContent().contains(row));
	}
	
	@Test
	public void testRemoveRowHashmap(){
		CSV csv = new CSV(genericContent);
		assertTrue(csv.addRow(row));
		assertTrue(csv.getContent().contains(row));
		assertTrue(csv.removeRow(row));
		assertFalse(csv.getContent().contains(row));
	}
	
	@Test
	public void testRemoveRowHashmapNegativeTest(){
		CSV csv = new CSV(genericContent);

		assertFalse(csv.getContent().contains(row));
		assertFalse(csv.removeRow(row));
		assertFalse(csv.getContent().contains(row));
	}
	
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	
	
}
