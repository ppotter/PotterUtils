package com.potter.java.sample;

import java.lang.reflect.Field;

public class ToString {
	public static String toString(Object object) {
		StringBuilder result = new StringBuilder();
		result.append( object.getClass().getName() );
		result.append( " {" );

		Field[] fields = object.getClass().getDeclaredFields();

		for (Field field : fields  ) {
			try {
				result.append(field.getName());
				result.append("= ");
				//requires access to private field
				result.append(field.get(object));
				result.append(", ");
			}
			catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
		}
		//remove the trailing comma.
//		result.deleteCharAt(result.lastIndexOf(","));
		result.append("}");

		return result.toString();
	}
	
	public static String toStringDebug(Object object) {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(object.getClass().getName());
		result.append(" {");
		result.append(newLine);

		Field[] fields = object.getClass().getDeclaredFields();

		for (Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append("= ");
				//requires access to private field:
				result.append(field.get(object));
			}
			catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}
}
