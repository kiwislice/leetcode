package leetcode.array;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		int a = 0;
		for(int n:nums) {
			a ^= n;
		}
		return a;
	}

	public int singleNumberMath(int[] nums) {
		Set<Integer> set = new TreeSet<>();
		int arraySum = 0;
		for(int n:nums) {
			set.add(n);
			arraySum += n;
		}
		
		int distinctNumSum2 = 0;
		for(int n:set) {
			distinctNumSum2 += n;
		}
		distinctNumSum2 <<= 1;
		
		return distinctNumSum2-arraySum;
	}

	public int singleNumberByList(int[] nums) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int n:nums) {
			if( !list.remove(Integer.valueOf(n)) ) {
				list.add(n);
			}
		}
		return list.get(0);
	}
	
}
