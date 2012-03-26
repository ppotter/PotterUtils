package com.potter.java.sample;

public class EnumExample2 {
	enum Direction {NORTH,SOUTH,EAST,WEST};

	public static void main(String[] args){
		System.out.println("Value of Enum: " + Direction.NORTH);
		System.out.println("Name of Enum: " + Direction.NORTH.name());
		System.out.println();
		System.out.println("Value of Enum: " + Direction.SOUTH);
		System.out.println("Name of Enum: " + Direction.SOUTH.name());
		System.out.println();
		System.out.println("Value of Enum: " + Direction.WEST);
		System.out.println("Name of Enum: " + Direction.WEST.name());
		System.out.println();
		System.out.println("Value of Enum: " + Direction.EAST);
		System.out.println("Name of Enum: " + Direction.EAST.name());
		System.out.println();
		System.out.println("Direction values:");
		for(Direction d : Direction.values()){
			System.out.println(d);
		}
		System.out.println();
		
		String directionAsString = "North";
		Direction dir = Direction.valueOf(directionAsString.toUpperCase());
		System.out.println("Value of Enum: " + dir);
		System.out.println("Name of Enum: " + dir);
		System.out.println();
		
	}
}
