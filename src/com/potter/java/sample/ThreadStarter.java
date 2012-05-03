package com.potter.java.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ThreadStarter {

	
	public static void main(String[] args){
		Threadable first = new Threadable("First","Processing for First");
		Threadable second = new Threadable("Second","Processing for Second");
		
		Thread one = new Thread(first);
		Thread two = new Thread(second);
		
		//run them sequentially.
		one.run();
		two.run();
		
		//run them concurrently.
		one.start();
		two.start();
		
		//depending on preference you can have the parent thread
		//wait for the child threads to finish or not before terminating.
		Collection<Thread> threads = new ArrayList<Thread>();
		threads.add(one);
		threads.add(two);
		
		try {
			if(args == null)waitForThreads(threads);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Parent thread closing");
		}
		
	}
	public static void waitForThreads(Collection<Thread> startThreads) throws InterruptedException{
		for (Iterator<Thread> assessor = startThreads.iterator(); assessor.hasNext();) {
			Thread thread = (Thread) assessor.next();
			waitForThread(thread);
		}
	}
	
	public static void waitForThread(Thread thread) throws InterruptedException{
		while(thread.isAlive()){
				synchronized (thread) {
					thread.wait();
				}
			}
		}
}
