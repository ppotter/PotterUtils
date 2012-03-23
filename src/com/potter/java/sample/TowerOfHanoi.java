package com.potter.java.sample;

public class TowerOfHanoi {

	public static void move(int n, String src, String aux, String dest){
		if(n>0){
			move(n-1, src,dest,aux);
			System.out.format("Move plate from %s to %s.%n",src,dest);
			move(n-1, aux,src,dest);
		}
	}
	
	public static void main(String[] arg){
		move(3,"A","B","C");
	}
	
}
