package com.ddavydenko.app;

public class Triangle implements Shape {
    
    private String type;
    private String color;
    private Point zeroCoordinates;
    private Point secondCoordinate;
    private Point thirdCoordinate;
    
    public Point getSecondCoordinate() {
        return secondCoordinate;
    }

    public void setSecondCoordinate(Point secondCoordinate) {
        this.secondCoordinate = secondCoordinate;
    }

    public Point getThirdCoordinate() {
        return thirdCoordinate;
    }

    public void setThirdCoordinate(Point thirdCoordinate) {
        this.thirdCoordinate = thirdCoordinate;
    }

    public Point getZeroCoordinates() {
        return zeroCoordinates;
    }

    public void setZeroCoordinates(Point zeroCoordinates) {
        this.zeroCoordinates = zeroCoordinates;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void draw() {
        System.out.println(getColor()+" "+getType()+" triangle is being drawn. It's zero coordinates are:["+zeroCoordinates.getCoordinateX()+", "
                            +zeroCoordinates.getCoordinateY()+"]\n It's 2-nd coordinates are:["+secondCoordinate.getCoordinateX()+", " 
                            +secondCoordinate.getCoordinateY()+"]\n It's 3-rd coordinates are:["+thirdCoordinate.getCoordinateX()+", " 
                            +thirdCoordinate.getCoordinateY()+"]\n ");
    }
}
