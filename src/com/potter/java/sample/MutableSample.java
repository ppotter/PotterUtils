package com.potter.java.sample;

import java.awt.Color;
import java.util.ArrayList;

import com.potter.java.utils.RecycleDeque;

//mutable example in the form of a simple stop light.
public class MutableSample {
	private Color[] availableColors = { Color.GREEN, Color.YELLOW, Color.RED };
	private ArrayList<Color> validColors = new ArrayList<Color>();
	private RecycleDeque<Color> colorQueue;
	
	public MutableSample(){
		colorQueue = new RecycleDeque<Color>();
		for(Color temp : availableColors){
			validColors.add(temp);
			colorQueue.add(temp);
		}
	}
	
	public boolean isValid(){
		return (validColors.contains(getCurrentLight()));
	}
	
	public void changeLight(){
		colorQueue.cycle();
	}
	
	public Color getCurrentLight(){
		return colorQueue.peek();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((colorQueue == null) ? 0 : colorQueue.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutableSample other = (MutableSample) obj;
		return this.getCurrentLight().equals(other.getCurrentLight());
	}
	
	
}
