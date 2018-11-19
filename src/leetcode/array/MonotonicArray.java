package leetcode.array;

/**
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMonotonic(int[] A) {
		if( A==null || A.length<=2 )
			return true;
		
		boolean up = A[0]<=A[A.length-1];
		
		for(int i=1;i<A.length;i++) {
			if( up ) {
				if( A[i-1]>A[i] ) return false;
			} else {
				if( A[i-1]<A[i] ) return false;
			}
		}
		return true;
	}

}
