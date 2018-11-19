package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] A = {1,3};

		System.out.println(Arrays.toString(sortArrayByParity(A)));
	}

	// 12 ms
	public static int[] sortArrayByParity(int[] A) {
		int R = A.length-1;
		int L = 0;
		
		while(L<R) {
			if( A[L]%2!=0 && A[R]%2==0 ) {
				int temp = A[R];
				A[R] = A[L];
				A[L] = temp;
				
				L++;
				R--;
			}
			else {
				if( A[L]%2==0 ) 
					L++;
				if( A[R]%2!=0 )
					R--;
			}
		}
		return A;
	}

	// 15 ms
	public int[] sortArrayByParityOld(int[] A) {
		int R = A.length-1;
		int L = 0;
		
		while(L<R) {
			if( A[L]%2==0 ) {
				L++;
				continue;
			}
			else {
				int temp = A[R];
				A[R] = A[L];
				A[L] = temp;
				
				R--;
			}
		}
		return A;
	}

}
