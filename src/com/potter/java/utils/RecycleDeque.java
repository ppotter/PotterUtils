package com.potter.java.utils;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;


/**
 * A queue designed to allow typical function a ArrayDeque would allow
 * but additionally allows the caller to cycle through items which will
 * alter the state/order the queue is in but not the total contents
 * of the queue.
 *  
 * @author ppotter
 *
 * @param <T>
 */

public class RecycleDeque<T> extends ArrayDeque<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecycleDeque(){
		super();
	}
	public RecycleDeque(Collection<T> arg0){
		super(arg0);
	}
	
	
	/**
	 * Removes the first item in the queue (returns this item at the end), 
	 * and adds the item back on the end of the queue.
	 * @return The first item in the queue.
	 */
	public T cycle(){
		T t = this.removeFirst();
		this.addLast(t);
		return t;
	}
	
	
	/**
	 * Removes the last item in the queue (returns this item at the end), 
	 * and adds the item back on the beginning of the queue.
	 * @return The first item in the queue.
	 */
	public T reverseCycle(){
		T t = this.removeLast();
		this.addFirst(t);
		return t;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		@SuppressWarnings("unchecked")
		RecycleDeque<T> that = (RecycleDeque<T>) obj;
		if (this.isEmpty() && that.isEmpty()) 
			return true;
		if(this.containsAll(that))
			if(that.containsAll(this)){
				Iterator<T> thisIterator = this.iterator();
				Iterator<T> thatIterator = that.iterator();
				while (thisIterator.hasNext()) {
					T tThis = (T) thisIterator.next();
					T tThat = (T) thatIterator.next();
					if(!tThis.equals(tThat)){
						return false;
					}
				}
			}
		return true;
	}
	
}
