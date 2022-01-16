package feature.basic_programs;

import java.util.ArrayList;
import java.util.List;

public class LaneChanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList<Integer>();
		al.add(2);
		al.add(3);
		al.add(2);
		al.add(1);
		al.add(3);
		al.add(1);
		
		winCounter(al);
	}
	private static void winCounter(List<Integer> al) {
		// TODO Auto-generated method stub
		int changeLaneCounter = 0;
		int startLane = 2;
		int looper =0;
		for(int lane: al) {
			if(startLane == lane) {
				if(startLane == 2 && al.get(looper+1) == 3) {
					startLane = 1;
					changeLaneCounter++;
				}
				else if(startLane ==1 && al.get(looper+1) == 2) {
					startLane = 3;
					changeLaneCounter++;
				}
				else if(startLane ==1 && al.get(looper+1) == 3) {
					startLane = 2;
					changeLaneCounter++;
				}
				else if(startLane == 2 && al.get(looper+1) == 1) {
					startLane = 3;
					changeLaneCounter++;
				}
				else if(startLane == 3 && al.get(looper+1) == 1) {
					startLane = 2;
					changeLaneCounter++;
				}
				else if(startLane == 3 && al.get(looper+1) == 2) {
					startLane = 1;
					changeLaneCounter++;
				}
			}
			looper++;
		}
		System.out.println(changeLaneCounter);
	}

}
