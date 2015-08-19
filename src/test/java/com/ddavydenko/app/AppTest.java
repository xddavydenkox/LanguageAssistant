package com.ddavydenko.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
    public void additionStringsTest() {
        TestClass test = new TestClass();

        String s= test.concatStrings("Hello, ", "there.");
        String expected = "Hello, there.";
        assertEquals("Method should concatinate 2 strings.", expected, s);
    };
    @Test 
    public void additionNumbersTest() {
    	TestClass test = new TestClass();
    	
    	int res = test.addNumbers(1, 100500);
    	int expected = 100501;
    	assertEquals("Method should sum up 2 numbers.", expected, res);
    }
    @Test
    public void getThreeTest() {
    	TestClass test = new TestClass();
    	assertEquals("Method should return number 3.", 3, test.getThree());
    }
    @Test
    public void doublesTheValueTest() {
    	TestClass test = new TestClass();
    	int testValue = 20;
    	
    	assertEquals("Method should double the value.", 40, test.doublesTheValue(testValue));
    }
    
    //Checks if the first value is greater than 2-nd.
    @Test
    public void isFirstBiggerTest() {
    	TestClass test = new TestClass();
    	
    	assertTrue(test.isFirstBigger(26, 25));
    	assertFalse(test.isFirstBigger(25, 25));
    	assertFalse(test.isFirstBigger(101, 99));
    	assertFalse(test.isFirstBigger(102, 101));
    	assertTrue(test.isFirstBigger(-10, -20));
    }
    
    //Checks if method reverses the given array.
    @Test
    public void reverseArrayTest() {
    	TestClass test = new TestClass();
    	
    	int[] testArray = {1,2,3,4,5,6,7,8};
    	int[] testArray2 = {1};
    	int[] testArray3 = {};
    	int[] expectedArray = {8,7,6,5,4,3,2,1};
    	int[] expectedArray2 = {1};
    	int[] expectedArray3 = {};
    	
    	int[] actualArray = test.reverseArray(testArray);
    	int[] actualArray2 = test.reverseArray(testArray2);
    	int[] actualArray3 = test.reverseArray(testArray3);
    	
    	assertArrayEquals(expectedArray, actualArray);
    	assertArrayEquals(expectedArray2,actualArray2);
    	assertArrayEquals(expectedArray3,actualArray3);
    }
    
    //Checks if method throws NullPointerException and if the test object is not null
    @Test (expected = NullPointerException.class)
    public void reverseArrayNullPointerTest() {
    	TestClass test = new TestClass();
    	
    	int[] testArray = null;
    	
    	test.reverseArray(testArray);
    	
    	assertNotNull(test);
    }
    
    //Just playing tiwh asserts of JUnit
    @Test
    public void objectReferenceTest() {
    	String s1 = "BOLD";
    	String s2 = "BOLD";
    	String s3 = "Bold";
    	TestClass test = new TestClass();
    	TestClass test2 = new TestClass();
    	
    	
    	assertSame(s1,s2);
    	assertNotSame(s2,s3);
    	assertEquals(s1,s3.toUpperCase());
    	assertNotSame(s1,s3.toUpperCase());
    	assertNotSame(test, test2);
    	
    	test = test2;
    	
    	assertSame(test,test2);
    }
}
