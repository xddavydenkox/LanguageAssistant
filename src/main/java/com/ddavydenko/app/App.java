package com.ddavydenko.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       Triangle triangle = (Triangle) context.getBean("triangle");
       triangle.draw();
       
       Circle circle = (Circle) context.getBean("circle");
       circle.draw();
       
       Shape shape = (Shape) context.getBean("square");
       shape.draw();
       
       Shape shape1 = (Shape) context.getBean("circle1");
       shape1.draw();

    }
}
