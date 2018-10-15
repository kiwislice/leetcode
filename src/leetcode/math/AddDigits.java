package leetcode.math;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {
	
	public static void main(String[] arg) {
		
		Set<Integer> set = new TreeSet<>();
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				set.add(i+j);
			}
		}
		System.out.println(set);
	}
	
	public int addDigits(int num) {
		return num<10?num:(num%9==0?9:num%9);
	}
	
}
