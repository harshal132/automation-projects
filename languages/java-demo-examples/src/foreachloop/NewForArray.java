package foreachloop;

import java.util.Arrays;


class NewForArray
{
	public static void main(String args[])
	{
		int j=0;
		int[] squares={0,1,4,9,16,25};
		System.out.println(Arrays.binarySearch(squares,4));
		int num[]=Arrays.copyOf(squares, 3);
		for(int i:squares)
		{
			System.out.println("The square of "+(j++)+" is "+i);
		}
		int num1[]=Arrays.copyOf(squares, 3);
		for(int val:num1)
		System.out.println(val);
		int val2[]=Arrays.copyOfRange(squares, 2, 4);
		for(int val:val2)
			System.out.println("j"+val);
		Arrays.fill(squares, 6);
		
		for(int i:squares)
		{
			System.out.println("The square of "+(j++)+" is "+i);
		}
		
	}
}
