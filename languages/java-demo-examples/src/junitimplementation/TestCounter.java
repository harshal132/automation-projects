package junitimplementation;




import static org.junit.Assert.*; 
import org.junit.Test; 


	public class TestCounter  { 
	Counter counter1=new Counter();
		public TestCounter() { }   // default constructor
				@Test
				public void Increment()
				{
				assertTrue(counter1.increment() == 1);
				assertTrue(counter1.increment() == 2);    
				}
				@Test
				public void Decrement() 
				{
					assertTrue(counter1.decrement() == -1);   
				}
}


