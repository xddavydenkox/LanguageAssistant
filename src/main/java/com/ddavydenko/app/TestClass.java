package com.ddavydenko.app;

<<<<<<< HEAD
import javax.swing.JOptionPane;

public class TestClass {

    public static String concatStrings(String a, String b)
    {
        return a+b;  
    }
    
    public static int addNumbers(int a, int b)
    {
        return a+b;  
    }
    
    public static boolean isFirstBigger(int a, int b)
    {
=======
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.junit.Ignore;

public class TestClass {

	public static int getThree() {
		return 3;
	}
	
    public static String concatStrings(String a, String b) {
        return a+b;  
    }
    
    public static int addNumbers(int a, int b) {
        return a+b;  
    }
    
    public static boolean isFirstBigger(int a, int b) {
>>>>>>> Just because
        if(a<=100 && b<=100)
        {
            return a>b;
        }
       return false;
    }
<<<<<<< HEAD
    public static int addThree(int number)
    {
        if(number>=0)
        {
        return number+=3;
        }
        else JOptionPane.showMessageDialog(null, "The number should not be negative!");
        return -1;
=======
    
    public static int doublesTheValue(int number) {
    	
        return number+=number;
        
    }
    
    public static int[] reverseArray(int[] arr) {
    	int temp = 0;
    	if(arr.length!=0 || arr.length!=1) {
    		for(int i=0; i<arr.length/2; i++) {
        		temp = arr[i];
        		arr[i]=arr[arr.length-i-1];
        		arr[arr.length-i-1] = temp;
        	}
        	return arr;
    	}
    	else return arr;
    }
    
    @Ignore
    public static void ignoreTest() {
    	System.out.println("Nevermind of what is written here.");
>>>>>>> Just because
    }
}
