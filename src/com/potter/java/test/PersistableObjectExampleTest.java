package com.potter.java.test;

import static org.mockito.Mockito.*;

import hirondelle.web4j.model.ModelUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;

import javax.management.InvalidAttributeValueException;

import junit.framework.TestCase;


import org.hamcrest.BaseMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.potter.java.sample.PersistableObjectExample;

public class PersistableObjectExampleTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHelloWorld(){
		//arrange
		Iterator i=mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		//act
		String result=i.next()+" "+i.next();
		//assert
		assertEquals("Hello World", result);
	}
	
	@Test
	public void testArguments(){
		Comparable c=mock(Comparable.class);
		when(c.compareTo("Test")).thenReturn(1);
		assertEquals(1,c.compareTo("Test"));
	}

	@Test
	public void testUnspecifiedArguments(){
		Comparable c=mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1,c.compareTo(5));
	}
	
	@Test(expected=IOException.class)
	public void testOutputStreamWriterRethrowsAnExceptionFromOutputStream() throws IOException {
		OutputStream mock=mock(OutputStream.class);
		OutputStreamWriter osw=new OutputStreamWriter(mock);
		doThrow(new IOException()).when(mock).close();
		try{
			osw.close();
			fail("Expected IOException when closing osw OutputStream.");
		}catch(IOException ex){
			//ignore this exception as it is expected and means the test passed.
		}
	}
	
	@Test
	public void testOutputStreamWriterClosesOutputStreamOnClose()
		 throws IOException{
		OutputStream mock=mock(OutputStream.class);
		OutputStreamWriter osw=new OutputStreamWriter(mock);
		osw.close();
		verify(mock).close();
	}
	
	@Test
	public void testValidStatePositive() throws InvalidAttributeValueException{
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(10), new Double(1.01));
		obj.validateState();
	}
	
	@Test
	public void testValidStateNegative() throws InvalidAttributeValueException{
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(-10), new Double(1.01));
		try{
			obj.validateState();
			fail("Expected InvalidAttributeValueException");
		}catch(IllegalArgumentException ex){
			//Test Passed exception expected
		}
	}
	
	@Test
	public void testClone() throws CloneNotSupportedException{
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(10), new Double(1.01));
		PersistableObjectExample clonedObj = obj.clone();
		assertTrue(obj.equals(clonedObj));
	}
	
	@Test
	public void testToString(){
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(10), new Double(1.01));
		assertEquals(ModelUtil.toStringFor(obj),obj.toString());
	}
	
	@Test
	public void testToStringDebug(){
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(10), new Double(1.01));
		assertFalse(ModelUtil.toStringFor(obj).equals(obj.toStringDebug()));
	}
	
	@Test
	public void testEquals() throws CloneNotSupportedException{
		PersistableObjectExample obj = new PersistableObjectExample("test", new Date(), new Integer(10), new Double(1.01));
		PersistableObjectExample obj2 = obj.clone();
		obj2.setfLong(new Long(1000000000));
		obj2.setfFloat(new Float(1.001));
		assertTrue(obj.equals(obj2));
	}
	
}
