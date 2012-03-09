package com.potter.java.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TreeSet;

public class IteratorExample {

	private Collection<String> collectables;
	
	public IteratorExample() {
		super();
	}
	
	public void outputCollectables(){
		for (Iterator iterator = collectables.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

	/**
	 * @return the collectables
	 */
	public Collection<String> getCollectables() {
		return collectables;
	}

	/**
	 * @param collectables the collectables to set
	 */
	public void setCollectables(Collection<String> collectables) {
		this.collectables = collectables;
	}
	
	public void addCollectables(String string){
		collectables.add(string);
	}
	
	public void addCollectables(String[] strings){
		for(int i = 0; i < strings.length; i++){
			collectables.add(strings[i]);
		}
	}

	public static void main(String[] args){
		String[] strings = {"asdf","asdf", "bsdf", "jkl;", "another example"};
		IteratorExample ex = new IteratorExample();
		ex.setCollectables(new ArrayList<String>());
		ex.addCollectables(strings);
		System.out.println("example of an Arraylist");
		ex.outputCollectables();
		
		System.out.println();
		System.out.println("example of a TreeSet");
		ex.setCollectables(new TreeSet<String>());
		ex.addCollectables(strings);
		ex.outputCollectables();
		
		System.out.println();
		System.out.println("example of a Stack");
		ex.setCollectables(new Stack<String>());
		ex.addCollectables(strings);
		ex.outputCollectables();
		
		
		
	}
}
