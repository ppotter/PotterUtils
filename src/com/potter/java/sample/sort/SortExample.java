package com.potter.java.sample.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortExample {

	public static void anagramSortExample(ArrayList<String> list){
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list,new AnagramComparator());
		System.out.println(list);
	}
	
	public static void stringSumSortExample(ArrayList<String> list){
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new StringValueComparator());
		System.out.println(list);
	}
	
	public static void setSortExample(ArrayList<String> list){
		SortedSet<String> set = new TreeSet<String>(new AnagramComparator());
		set.addAll(list);
		System.out.println(set);
	}
	
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("anna");
		list.add("anan");
		list.add("nana");
		list.add("asdf");
		list.add("fdsa");
		list.add("aaaa");
		list.add("dddd");
		
		stringSumSortExample(list);
	}
}
