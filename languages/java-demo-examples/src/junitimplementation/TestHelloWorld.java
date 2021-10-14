package junitimplementation;

import junit.framework.TestCase;


public class TestHelloWorld extends TestCase { 
    public TestHelloWorld( String name) 
       { super(name); } 
    public void testSay() 
       {   HelloWorld hi = new HelloWorld(); 
           assertEquals("Hello World!", hi.say());
           
           }
    
     } 

