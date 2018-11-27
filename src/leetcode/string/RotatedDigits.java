package leetcode.string;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/rotated-digits/
 */
public class RotatedDigits {

	public static void main(String[] args) {
		// 4
//		int N = 10;
		// 247
		int N = 857;
		// 129
//		int N = 459;
		
//		int N = 300;
		
//		int[] nar = toIntAr(N);
//		System.out.println(rotatedDigitsCount(nar, 0));
//		System.out.println(rotatedDigitsCount018(nar, 0));
//		
		IntStream.range(1, N+1).forEach(i -> System.out.println(i+" -> "+rotatedDigits(i)));
		
	}

	public static int rotatedDigits(int N) {
		int[] nar = toIntAr(N);
		// 計算[1,N]之間只由0,1,2,5,6,8,9構成的數量
		int rtn = rotatedDigitsCount(nar, 0, nums);
		// 計算[1,N]之間只由0,1,8構成的數量
		rtn -= rotatedDigitsCount(nar, 0, failNums);
		return rtn;
	}

	static int[] failNums = {0,1,8};
	static int[] nums = {0,1,2,5,6,8,9};
	
	/** 計算在[1,nar]之間，只由nums內數字構成的數量 */
	public static int rotatedDigitsCount(int[] nar, int i, int[] nums) {
		if( i>=nar.length )
			return 0;
		int niNumsCount = numsCount(nar[i], nums);
		
		int rtn = 0;
		if( nar[i]==nums[niNumsCount-1] ) {
			rtn = (niNumsCount-1) * (int) Math.pow(nums.length, nar.length-i-1);
			rtn += rotatedDigitsCount(nar, i+1, nums);
		} else {
			rtn = niNumsCount * (int) Math.pow(nums.length, nar.length-i-1);
			rtn--;
		}
		return rtn;
	}
	
	/** 計算n<=nums[i]的數量 */
	private static int numsCount(int n, int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if( n<nums[i] )
				return i;
		}
		return nums.length;
	}
	
	private static int[] toIntAr(int N) {
		String s = Integer.toString(N);
		int[] rtn = new int[s.length()];
		for(int i=0;i<rtn.length;i++) {
			rtn[i] = s.charAt(i)-'0';
		}
		return rtn;
	}
	
}
