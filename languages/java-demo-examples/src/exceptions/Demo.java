package exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Demo {
	double salary;
	public  void raiseSalary(double amount) throws ApplicationException    	{
		try
		{
		if(salary<10000.00)
		{
			//throw new RuntimeException("Salary can not be raised . Illegal operation");  // unchecked
			//throw new Exception("Salary can not be raised . Illegal operation"); // checked
			throw new ApplicationException("Salary can not be raised . Illegal operation"); // checked
		}
		else
		{
			salary=salary+amount;
		}
		}
		finally{
			System.out.println("Finally in raiseSalary method executed");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo ob=new Demo();
		Scanner sc=new Scanner(System.in);
		try{
		while(true)  		{
			try  			{
				System.out.println("Enter the salary");
				ob.salary=sc.nextDouble();
				if(ob.salary>0.0)  break;
				else continue;
			}catch(InputMismatchException e)
			{
				System.out.println("Enter Valid salary");
				sc.nextLine();
			}
		
		}
		ob.raiseSalary(5000.00);
		}
		catch(Exception e)
		{
			System.out.println("Caught in main "+e);
		}
		finally{
			System.out.println("Finally in main method executed");
		}
		System.out.println("Raised salary is "+ob.salary);
		
	}

}
