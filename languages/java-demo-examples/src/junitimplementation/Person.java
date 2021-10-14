package junitimplementation;


public class  Person
{
	private String firstName;
	private String lastName;

	public Person(String fname,String lname)
	{
		if(fname == null && lname==null){
			throw new IllegalArgumentException("Both Names Cannot be NULL");
		}
		this.firstName=fname;
		this.lastName = lname;
	}

public String getFullName()
{
	String first=(this.firstName != null)? this.firstName:"?";
	String last=(this.lastName != null)? this.lastName:"?";
	return first + " " + last;
}

public String getFirstName(){
	return this.firstName;
}

public String getLastName(){
	return this.lastName;
}
public static void main(String args[])
{
	Person p=new Person("a","b");
	System.out.println(p.getFirstName());
}
}