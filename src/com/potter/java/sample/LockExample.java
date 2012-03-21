package com.potter.java.sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	static class Resource{
		private final Lock lock = new ReentrantLock();
		private final Map<Integer,String> map;
		
		public Resource(){
			map = new HashMap<Integer,String>();
		}
		public Resource(Map<Integer,String> map){
			this.map = map;
		}
		
		public String get(Integer key){
			String result = "";
			if(lock.tryLock()){
				try{
					result = map.get(key);
				}finally{
					lock.unlock();
				}
			}else{
				System.out.println("Resource could not be obtained.");
			}
			return result;
		}
		
		public boolean update(Integer key, String value){
			boolean result = false;
			
			if(lock.tryLock()){
				try{
					map.put(key, value);
					result = true;
				}finally{
					lock.unlock();
				}
			}else{
				System.out.println("Resource could not be obtained.");
			}
			return result;
		}
		
		public boolean remove(Integer key){
			boolean result = false;
			
			if(lock.tryLock()){
				try{
					map.remove(key);
					result = true;
				}finally{
					lock.unlock();
				}
			}else{
				System.out.println("Resource could not be obtained.");
			}
			return result;
		}
	}
	
	static class ResourceReader implements Runnable{
		Resource resource;
		
		public ResourceReader(Map<Integer,String> map){
			resource = new Resource(map);
		}
		
		public String readResource(Integer num){
			return resource.get(num);
		}
		
		public void run(){
			Random rand = new Random(System.currentTimeMillis());
			for(;;){
				try{
					Thread.sleep(rand.nextInt(15));
				}catch(InterruptedException e){}
				
				Integer key = new Integer(rand.nextInt(50));
				System.out.format("Reading: [%s] value: [%s]%n", key.toString(),readResource(key));
			}
		}
	}
	
	static class ResourceUpdater implements Runnable{
		Resource resource;
		
		public ResourceUpdater(Map<Integer,String> map){
			resource = new Resource(map);
		}
		
		public void updateResource(Integer key,String value){
			resource.update(key, value);
		}
		
		public void run(){
			Random rand = new Random(System.currentTimeMillis());
			for(;;){
				try{
					Thread.sleep(rand.nextInt(15));
				}catch(InterruptedException e){}
				
				Integer key = new Integer(rand.nextInt(50));
				String value = "value" + key.toString();
				System.out.format("Updating: [%s] value: [%s]%n", key.toString(),value);
				updateResource(key, value);
			}
		}
	}
	
	public static void main(String[] args){
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		ResourceUpdater updater = new ResourceUpdater(map);
		ResourceReader reader = new ResourceReader(map);
		new Thread(updater).start();
		new Thread(reader).start();
	}
}
