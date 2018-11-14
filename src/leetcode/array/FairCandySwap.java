package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class FairCandySwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] fairCandySwap(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		
		for(int i=0;i<A.length;i++) {
			sumA += A[i];
		}
		for(int i=0;i<B.length;i++) {
			sumB += B[i];
		}
		
		int ax_by = (sumA-sumB)/2;
		Set<Integer> set = new HashSet<>();
		if( A.length>B.length ) {
			for(int i=0;i<B.length;i++) {
				set.add(B[i]+ax_by);
			}
			for(int i=0;i<A.length;i++) {
				if( set.contains(A[i]) )
					return new int[] {A[i], A[i]-ax_by};
			}
		}
		else {
			for(int i=0;i<A.length;i++) {
				set.add(A[i]-ax_by);
			}
			for(int i=0;i<B.length;i++) {
				if( set.contains(B[i]) )
					return new int[] {B[i]+ax_by, B[i]};
			}
		}
		return null;
	}

}
