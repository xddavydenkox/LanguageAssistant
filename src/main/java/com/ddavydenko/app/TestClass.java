package com.ddavydenko.app;

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
        if(a<=100 && b<=100)
        {
            return a>b;
        }
       return false;
    }
    public static int addThree(int number)
    {
        if(number>=0)
        {
        return number+=3;
        }
        else JOptionPane.showMessageDialog(null, "The number should not be negative!");
        return -1;
    }
}
