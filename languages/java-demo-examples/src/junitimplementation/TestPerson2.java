package junitimplementation;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class  TestPerson2 
{
	@Test
	public void testGetFullName()
	{
		System.out.println("from TestPerson2");
		Person per = new Person("Robert","King");
		assertEquals("Robert King",per.getFullName());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNullsInName()
		{
		System.out.println("from TestPerson2 testing exceptions");
		Person per1 = new Person(null,null);		
		}

}