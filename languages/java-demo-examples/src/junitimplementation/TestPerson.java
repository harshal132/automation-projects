package junitimplementation;

import static org.junit.Assert.*; 

import org.junit.*;

public class  TestPerson 
{	
	@Test
	public void GetFullName()
	{
		System.out.println("from TestPerson1");
		Person per = new Person("Robert","King");
		assertEquals("Robert King",per.getFullName());
	}
	@Test 
	public void NullsInName()
	{
		System.out.println("from TestPerson1");
		Person per1 = new Person("Robert","King");
		assertNotNull("full name null", per1.getFullName());
		assertNotNull( "First name null",per1.getFirstName());

		Person per2 = new Person("Robert","King");
		assertEquals("Robert King", per2.getFullName());
	}
	@Test
	public void GetFirstName()
	{
		Person p = new Person("Robert", "King");
		assertEquals(p.getFirstName(), "Robert");
	}
	@Test
	public void testGetLastName()
	{
		Person p = new Person("Robert", "King");
		assertEquals(p.getLastName(), "King");
	}
}