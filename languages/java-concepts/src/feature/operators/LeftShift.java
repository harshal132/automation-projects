package feature.operators;

public class LeftShift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int i;
		    int num = 16;
		    System.out.println("-------Left shift ---------");
		    for(i=0; i<4; i++) {
		      num = num << 1;
		      System.out.println(num);
		    
		    }
		    System.out.println("-------Right shift ---------");
		    for(i=0; i<4; i++) {
			      num = num >> 1;
			      System.out.println(num);
			    
			}
	}
}
