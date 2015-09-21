package com.ddavydenko.app;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    /*private static final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    private static SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");*/
    
    public static void main( String[] args ) {

        Random randomGenerator = new Random();
            
            for (int i=0; i<10; i++) {
                int randomInt = randomGenerator.nextInt(10);
                System.out.println(randomInt);
        }
        
    }

}
