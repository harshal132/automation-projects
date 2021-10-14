package junitimplementation;

public class Student
{
	int	rollNo;
	String	firstName;
	String	lastName;

	Student(int rollNo, String firstName, String lastName)
	{
		this.rollNo		= rollNo;
		this.firstName	= firstName;
		this.lastName	= lastName;
	}

	int	getRollNo()
	{
		return rollNo;
	}

	String	getFirstName()
	{
		return firstName;
	}

	String	getLastName()
	{
		return lastName;
	}
}