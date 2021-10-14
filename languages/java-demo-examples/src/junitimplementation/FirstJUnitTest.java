package junitimplementation;


import static org.junit.Assert.*; 
import org.junit.Test; 
  public class FirstJUnitTest {
    @Test 
          public void simpleAdd() { 
	   int result = 1; 
	   int expected = 1; 
	   assertEquals(result, expected); 
  } } 
