package leetcode.hashtable;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2NArray {

	public static void main(String[] args) {
//		int[] A = {5,1,5,2,5,3,5,4};
		int[] A = {1,2,3,3};

		System.out.println(repeatedNTimes(A));
	}

	/** 5 ms, faster than 89.13% */
	public static int repeatedNTimes(int[] A) {
		for(int i=0;i<A.length-2;i++) {
			if( A[i]==A[i+1] || A[i]==A[i+2] ) 
				return A[i];
		}
		if( A[A.length-2]==A[A.length-1] || A[0]==A[A.length-1] )
			return A[A.length-1];
		return -1;
	}

	/** 4 ms, faster than 99.96% */
	public static int repeatedNTimesByBooleanArray(int[] A) {
		boolean[] b = new boolean[10000];
		for(int a:A) {
			if( b[a] ) 
				return a;
			b[a] = true;
		}
		return -1;
	}

}
