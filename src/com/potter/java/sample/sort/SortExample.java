package com.potter.java.sample.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortExample {

	public static void anagramSortExample(ArrayList<String> list){
		Collections.sort(list);
		for(String s : list){
			System.out.println(s);
		}
		Collections.sort(list,new AnagramComparator());
		for(String s : list){
			System.out.println(s);
		}
	}
	
	public static void stringSumSortExample(ArrayList<String> list){
		Collections.sort(list);
		for(String s : list){
			System.out.println(s);
		}
		
		Collections.sort(list, new StringValueComparator());
		for(String s : list){
			System.out.println(s);
		}
	}
	
	public static void setSortExample(ArrayList<String> list){
		SortedSet<String> set = new TreeSet<String>(new AnagramComparator());
		set.addAll(list);
		for(String s : set){
			System.out.println(s);
		}
	}
	
	public static void priorityQueueSortExample(ArrayList<String> list){
		PriorityQueue<String> queue = new PriorityQueue<String>(15,new StringValueComparator());
		queue.addAll(list);
		
		//the order accessed during printout and poll vary from each other
		//and from insertion order.
		System.out.println(queue);
		System.out.println();
		System.out.println("------------");
		
		String output;
		while((output = queue.poll()) != null){
			System.out.println(output);
		}
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
