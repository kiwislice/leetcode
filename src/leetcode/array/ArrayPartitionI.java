package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartitionI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 10 ms
	public int arrayPairSum(int[] nums) {
		int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}

	// 25 ms
	public int arrayPairSumBySort(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i=0;i<nums.length;i+=2) {
			sum += nums[i];
		}
		return sum;
	}

}
