package feature.basic_programs;

import java.util.ArrayList;
import java.util.List;

public class MeanderingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(-1);
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(-5);
		
		//sortArray(al);
		
		ascendingSort(al);
	}

	private static void ascendingSort(List<Integer> al) {
		int temp = 0;
		for(int i=0; i<al.size(); i++) {
			for(int j = i+1; j<al.size(); j++) {
				if(al.get(i)>al.get(j)) {
					temp = al.get(j);
					al.set(j, al.get(i));
					al.set(i, temp);
				}
			}
		}
		
		System.out.println(al);
	}

	private static void sortArray(List<Integer> al) {
		// TODO Auto-generated method stub
		List<Integer> copyAl = new ArrayList<Integer>();
		copyAl.addAll(al);
		List<Integer> result = new ArrayList<Integer>();
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		//find largest
		int listSize = copyAl.size();
		int count = 0;
		while(count < listSize) {
			for(int x: copyAl) {
				if(largest < x) {
					largest = x;
				}
			}
			result.add(largest);
			copyAl.remove(Integer.valueOf(largest));
			largest = Integer.MIN_VALUE;
			count++; 
			
			if(count< listSize) {
				for(int y: copyAl) {
					if(smallest > y) {
						smallest = y;
					}
				}
				result.add(smallest);
				copyAl.remove(Integer.valueOf(smallest));
				smallest = Integer.MAX_VALUE;
				count++;
			}
			
		}
		
		//display list
		System.out.println(result);
	}
	
/*
 * void rearrange(int arr[], int n)
{
    // Auxiliary array to hold modified array
    int temp[n];
 
    // Indexes of smallest and largest elements
    // from remaining array.
    int small = 0, large = n - 1;
 
    // To indicate whether we need to copy remaining
    // largest or remaining smallest at next position
    int flag = true;
 
    // Store result in temp[]
    for (int i = 0; i < n; i++) {
        if (flag)
            temp[i] = arr[large--];
        else
            temp[i] = arr[small++];
 
        flag = !flag;
    }
 
    // Copy temp[] to arr[]
    for (int i = 0; i < n; i++)
        arr[i] = temp[i];
}*/
}
