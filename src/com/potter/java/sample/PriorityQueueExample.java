package com.potter.java.sample;

import java.util.PriorityQueue;

import com.potter.java.sample.sort.StringValueComparator;

public class PriorityQueueExample {

	
	public static void main(String[] args){
		PriorityQueue<String> queue = 
			new PriorityQueue<String>(15, new StringValueComparator());
		queue.add("z");
		queue.add("c");
		queue.add("d");
		queue.add("b");
		queue.add("a");
		queue.add("t");
		queue.add("o");
		queue.add("aa");
		
		
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
}
