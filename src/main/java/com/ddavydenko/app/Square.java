package com.ddavydenko.app;

public class Square implements Shape {
    private int anglesNumber;
    
    public int getAnglesNumber() {
        return anglesNumber;
    };
    
    public int setAnglesNumber(int anglesNumber) {
        return this.anglesNumber = anglesNumber;
    }

    @Override
    public void draw() {
        System.out.println("I am a square and I have "+getAnglesNumber()+" angles");
    };
}
