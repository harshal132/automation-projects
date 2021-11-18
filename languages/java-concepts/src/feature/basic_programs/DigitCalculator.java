package feature.basic_programs;

public class DigitCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long index = calculateTotal(-987654321);
		System.out.println(index);
	}
	
	public static long calculateTotal(long input) {
		if(input<0) {
			input = input * -1;
		}
		long sum = 0;
		while(input!=0)
		{
			sum = sum + input%10;
			input = input/10;
		}
		if(sum>26) {
			sum = calculateTotal(sum);
			return sum;
		}
		else {
			return sum;
		}
		
	}

}
