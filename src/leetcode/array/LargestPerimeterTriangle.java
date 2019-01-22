package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class LargestPerimeterTriangle {

	public static void main(String[] args) {
//		int[] A = {3,6,2,3};
//		int[] A = {3,2,3,4};
//		int[] A = {1,2,1};
		// 11
		int[] A = {3,4,15,2,9,4};
		
		System.out.println(largestPerimeter(A));
	}

	public static int largestPerimeter(int[] A) {
		Arrays.sort(A);
		for(int ic=A.length-3;ic>=0;ic--) {
			if( A[ic]+A[ic+1]>A[ic+2] )
				return A[ic]+A[ic+1]+A[ic+2];
		}
		return 0;
	}

}
