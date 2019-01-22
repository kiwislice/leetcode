package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {

	public static void main(String[] args) {
//		int[] A = {-4,-1,0,3,10};
//		int[] A = {-7,-3,2,3,11};
		int[] A = {1};
//		int[] A = {0,2};

		System.out.println(Arrays.toString(sortedSquares(A)));
	}

	/** 13 ms, faster than 100.00% */
	public static int[] sortedSquares(int[] A) {
		int count = A.length;
		int[] rtn = new int[count];
		
		int iL = 0, iR = count-1;
		int sL = A[iL]*A[iL], sR = A[iR]*A[iR];
		while( count > 0 ) {
			if( sL>=sR ) {
				rtn[count-1] = sL;
				iL++;
				sL = iL<A.length?A[iL]*A[iL]:-1;
			}
			else {
				rtn[count-1] = sR;
				iR--;
				sR = iR>0?A[iR]*A[iR]:-1;
			}
			count--;
		}
		return rtn;
	}

}
