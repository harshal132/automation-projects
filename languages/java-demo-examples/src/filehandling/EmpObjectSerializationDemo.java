package filehandling;

/*
This is an example demonstrating Object Serialization Mechanism.
*/

import java.io.*;

// This is a serializable object
class Employee implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	double salary;

	Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public void showDetails() {
		System.out.println("Name	:" + name);
		System.out.println("Age		:" + age);
		System.out.println("Salary	:" + salary);
	}
}


class EmpObjectSerializationDemo {
  	
	void writeData() {

		Employee db[] = {
					new Employee("Sachin",25,12000.56), 
					new Employee("Rahul",24,12670.78),
					new Employee("Hritik",28,16000.89)
					};
		try(FileOutputStream out = new FileOutputStream("emp-obj.dat");
				ObjectOutputStream sout = new ObjectOutputStream(out);)	{
			
			for (int i = 0; i < db.length ; i++ ) {
				sout.writeObject(db[i]);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	void readData() {
		try(FileInputStream in = new FileInputStream("emp-obj.dat");
				ObjectInputStream sin = new ObjectInputStream(in);)	{
			
			Employee e = (Employee) sin.readObject();
			e.showDetails();
			e = (Employee) sin.readObject();
			e.showDetails();
			e = (Employee) sin.readObject();	
			e.showDetails();
			sin.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

	public static void main(String  args[]) {

		EmpObjectSerializationDemo impl = new EmpObjectSerializationDemo();
		impl.writeData();
		impl.readData();
	}

}

