package feature.operators;

public class PrefixPostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int numA = 5;
		    int numB = 10;
		    int numC = 0;

		    numC = --numA + numB--;
		    System.out.println("Number A = "+numA);
		    System.out.println("Number B = "+numB);
		    System.out.println("Number C = "+numC);
		    
    		//Number A = 4
    		//Number B = 9
    		//Number C = 14

		  
	}

}
