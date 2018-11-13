package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] ar = {1,1,1,1,1,1,1,2,1,2,3,4,3,4,2,1,2};
		
		System.out.println(majorityElement(ar));
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
        int num = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i == num) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    num = i;
                    count = 1;
                }
            }
        }
        return num;
	}

	public int majorityElementByMap(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		final int target = (nums.length+1)/2;
		for(int i:nums) {
			int count = m.getOrDefault(i, 0);
			count++;
			if( count>=target )
				return i;
			m.put(i, count);
		}
		return 0;
	}

}
