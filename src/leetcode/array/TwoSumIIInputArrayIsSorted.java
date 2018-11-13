package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		int L = 0;
		int R = numbers.length-1;
		
		while(L<R) {
			if( numbers[L]+numbers[R]==target ) {
				return new int[] {L+1,R+1};
			}
			else if(numbers[L]+numbers[R]>target) {
				R--;
			}
			else {
				L++;
			}
		}
		return new int[] {0,0};
	}

	public int[] twoSumByMap(int[] numbers, int target) {
		Map<Integer, Integer> m = new HashMap<>();
		for(int i=0;i<numbers.length;i++) {
			if( m.containsKey(numbers[i]) ) {
				return new int[] {m.get(numbers[i])+1, i+1};
			}
			m.put(target-numbers[i], i);
		}
		return new int[] {0,0};
	}

}
