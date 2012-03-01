package com.potter.java.sample;

import java.util.Random;

public class SampleThreadable implements Runnable {

	private static final int seconds = 1000;
	protected boolean running = false;
	protected boolean requestedStop = false;
	protected String threadName;
	protected String output;
	
	public synchronized boolean isRequestedStop(){
		return requestedStop;
	}
	
	public synchronized void requestStop(){
		requestedStop = true;
	}
	
	public SampleThreadable(String threadName,String output){
		this.threadName = threadName;
		this.output = output;
		System.out.println("Constructing Thread: " + threadName);
	}
	
	@Override
	public void run() {
		running = true;
		try{
			while(running && !isRequestedStop()){
				
				System.out.println("Starting Thread:" + threadName);
				//Do/Call Process functions here
				Thread.sleep(500);
				doStuff();
				running = false;
			}
		}catch(InterruptedException ex){
			//TODO handle interrupt
			//log interrupt.
		}finally{
			
			System.out.println("Closing Thread:" + threadName);
			//notifying parent thread that could be waiting on
			//the child thread is complete.
			synchronized (this) {
				this.notify();
			}
			
		}
		
		
	}
	
	private void doStuff(){
		try{
			Random rand = new Random();
			int wait = Math.abs(((rand.nextInt()%10)+1));
			Thread.sleep( wait * seconds);
			System.out.println(output);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

}
