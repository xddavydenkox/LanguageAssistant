package com.ddavydenko.app;

import org.hibernate.*;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domains.EngWords;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       SessionFactory sessionFactory =  (SessionFactory) context.getBean("sessionFactory");
       Session session = sessionFactory.openSession();
       Transaction tr = session.beginTransaction();
       
       
       EngWords words = new EngWords();
       
       words.setCategory("Numbers");
       words.setTopic("1-10");
       words.setRusword("один");
       words.setEngword("one");
       
       session.save(words);
       tr.commit();
       session.close();
       }
}
