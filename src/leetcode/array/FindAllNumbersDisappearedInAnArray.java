package leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 9 ms
	public List<Integer> findDisappearedNumbers(int[] nums) {
		boolean[] bs = new boolean[nums.length+1];
		for(int n:nums) {
			bs[n] = true;
		}
		
		List<Integer> rtn = new LinkedList<>();
		for(int i=1;i<bs.length;i++) {
			if( !bs[i] )
				rtn.add(i);
		}
		return rtn;
	}

	// 13 ms
	public List<Integer> findDisappearedNumbersOld(int[] nums) {
		boolean[] bs = new boolean[nums.length];
		for(int n:nums) {
			bs[n-1] = true;
		}
		
		List<Integer> rtn = new LinkedList<>();
		for(int i=0;i<bs.length;i++) {
			if( !bs[i] )
				rtn.add(i+1);
		}
		return rtn;
	}

}
