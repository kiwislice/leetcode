package leetcode.array;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class MaximizeDistanceToClosestPerson {

	public static void main(String[] args) {
//		int[] seats = {0,1};
//		int[] seats = {1,0,1};
//		int[] seats = {1,0,0,1,0,1,0,1};
		int[] seats = {1,1,1,0,1,0,1,1,0,0,1};
		
		System.out.println(maxDistToClosest(seats));
	}

	public static int maxDistToClosest(int[] seats) {
		int maxDist = 0;
		
		int L = 0;
		int R = seats.length-1;
		
		while(seats[L]==0) {L++;}
		while(seats[R]==0) {R--;}
		
		if( L>(seats.length-1-R) ) {
			maxDist = L;
		} else {
			maxDist = seats.length-1-R;
		}
		
		int count = 0;
		for(int i=L;i<=R;i++) {
			if( seats[i]==0 ) {
				count++;
			}
			else {
				if( (count+1)/2>maxDist ) {
					maxDist = (count+1)/2;
				}
				count = 0;
			}
		}
		return maxDist;
	}

}
