package com.potter.java.test;

import com.potter.java.utils.FuzzyCompare;

import org.junit.Test;

import junit.framework.TestCase;

public class FuzzyCompareTest extends TestCase {

	
	@Test
	public void testNullEquals(){
		String nullable = null;
		assertTrue(FuzzyCompare.equals(nullable, nullable));
	}
	@Test
	public void testNegativeNullEquals(){
		String nullable = null;
		String notNull = "";
		assertFalse(FuzzyCompare.equals(nullable, notNull));
		assertFalse(FuzzyCompare.equals(notNull, nullable));
	}

	@Test
	public void testEmptyEquals(){
		String notNull = "";
		assertTrue(FuzzyCompare.equals(notNull, notNull));
	}
	
	@Test
	public void testEmptyNegativeEquals(){
		String empty = "", notNull = "a";
		assertFalse(FuzzyCompare.equals(empty, notNull));
		assertFalse(FuzzyCompare.equals(notNull, empty));
	}
	
	@Test
	public void testSimpleEquals(){
		String a = "a", b = "b";
		assertTrue(FuzzyCompare.equals(a, a));
		assertFalse(FuzzyCompare.equals(a, b));
		assertFalse(FuzzyCompare.equals(b, a));
		assertTrue(FuzzyCompare.equals(b, b));
	}
	
	@Test
	public void testCaseInsensitiveEquals(){
		String a = "a", b = "b", A = "A";
		assertTrue(FuzzyCompare.equals(a, A));
		assertFalse(FuzzyCompare.equals(A, b));
		assertFalse(FuzzyCompare.equals(b, A));
		assertTrue(FuzzyCompare.equals(A, A));
	}
	
	@Test
	public void testWhiteSpaceEquals(){
		String aa = "aa", empty = "", space = " ", aaSpace = "a a";
		assertTrue(FuzzyCompare.equals(aa, aa));
		assertFalse(FuzzyCompare.equals(aa, empty));
		assertFalse(FuzzyCompare.equals(aa, space));
		assertTrue(FuzzyCompare.equals(empty, space));
		assertTrue(FuzzyCompare.equals(aa, aaSpace));
	}
	
	@Test
	public void testWhiteSpaceComplexEquals(){
		String withSpaces = "Normal test case with spaces";
		String noSpaces = "Normaltestcasewithspaces";
		assertTrue(FuzzyCompare.equals(withSpaces, noSpaces));
	}
	
	@Test
	public void testNumbersSimpleEquals(){
		String a = "a123", b = "b123", c = "123", d = "a", e = "a321", f = "321";
		assertTrue(FuzzyCompare.equals(a, a));
		assertTrue(FuzzyCompare.equals(a, b));
		assertTrue(FuzzyCompare.equals(b, a));
		assertTrue(FuzzyCompare.equals(a, c));
		assertTrue(FuzzyCompare.equals(c, a));
		
		assertFalse(FuzzyCompare.equals(a, d));
		assertFalse(FuzzyCompare.equals(d, a));
		assertFalse(FuzzyCompare.equals(c, d));
		assertFalse(FuzzyCompare.equals(d, c));
		
		assertFalse(FuzzyCompare.equals(a, e));
		assertFalse(FuzzyCompare.equals(e, a));
		assertFalse(FuzzyCompare.equals(c, e));
		assertFalse(FuzzyCompare.equals(e, c));
		
		assertFalse(FuzzyCompare.equals(a, f));
		assertFalse(FuzzyCompare.equals(f, a));
		assertFalse(FuzzyCompare.equals(c, f));
		assertFalse(FuzzyCompare.equals(f, c));
	}
	
	@Test
	public void testNumbersCharacterSimpleEquals(){
		String a = "aaaa123", b = "bbbb123", c = "123", d = "aaaa", e = "a1a2a3a", f = "a a a a ";
		assertTrue(FuzzyCompare.equals(a, a));
		
		assertTrue(FuzzyCompare.equals(a, d));
		assertTrue(FuzzyCompare.equals(d, a));
		assertTrue(FuzzyCompare.equals(a, e));
		assertTrue(FuzzyCompare.equals(e, a));
		
		assertTrue(FuzzyCompare.equals(a, f));
		assertTrue(FuzzyCompare.equals(f, a));
		assertTrue(FuzzyCompare.equals(f, e));
		assertTrue(FuzzyCompare.equals(e, f));
		
		assertTrue(FuzzyCompare.equals(d, e));
		assertTrue(FuzzyCompare.equals(e, d));
		assertTrue(FuzzyCompare.equals(d, f));
		assertTrue(FuzzyCompare.equals(f, d));
		
		assertFalse(FuzzyCompare.equals(a, b));
		assertFalse(FuzzyCompare.equals(b, a));
		assertFalse(FuzzyCompare.equals(a, c));
		assertFalse(FuzzyCompare.equals(c, a));
	}
	
	
}
