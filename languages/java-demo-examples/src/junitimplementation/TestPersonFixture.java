package junitimplementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class  TestPersonFixture 
{	
	/*@BeforeClass
	public static void setBeforeAllTests()
	{
		System.out.println("One time initialization code before all tests");		
	}
	@AfterClass
	public static void doAfterAllTests()
	{
		System.out.println("One time cleanup code after all tests");
	}*/
	
	/*@Before
	public void setbeforeTests()
	{
		System.out.println("Here is the initialization code");		
	}
	@After
	public void doafterTests()
	{
		System.out.println("Here is the cleanup code");
	}*/
	
	
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
}