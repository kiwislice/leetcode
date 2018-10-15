package leetcode.math;

public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] {3,0,1}));

	}

	public static int missingNumber(int[] nums) {
		int sum = (nums.length+1)*nums.length/2;
		for(int i:nums) {
			sum -= i;
		}
		return sum;
	}

}
