package leetcode.array;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

	public static void main(String[] args) {
		// true
		int[] A = {3,5,5};

		System.out.println(validMountainArray(A));
	}

	/** 3 ms, faster than 100.00% */
	public static boolean validMountainArray(int[] A) {
		if( A==null || A.length<3 )
			return false;
		
		int lMaxIndex = -1, rMaxIndex = -1;
		for(int i=0;i<A.length-1;i++) {
			if( A[i]>=A[i+1] ) {
				lMaxIndex = i;
				break;
			}
		}
		for(int i=A.length-1;i>0;i--) {
			if( A[i]>=A[i-1] ) {
				rMaxIndex = i;
				break;
			}
		}
		return lMaxIndex!=-1 && rMaxIndex!=-1 && lMaxIndex==rMaxIndex;
	}

}
