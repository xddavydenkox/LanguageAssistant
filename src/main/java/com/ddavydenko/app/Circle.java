package com.ddavydenko.app;

public class Circle implements Shape {
    private String type;
    private String color;
    
    public Circle() {
    }
    public Circle(String type, String color) {
        this.color = color;
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public void draw() {
        System.out.println(getColor()+" "+getType()+" circle is being drawn.");
    }
}
