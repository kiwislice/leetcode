package leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/powerful-integers/
 */
public class PowerfulIntegers {

	public static void main(String[] args) {
		int x = 3, y = 5, bound = 15;

		System.out.println(powerfulIntegers(x, y, bound));
	}

	/** 5 ms, faster than 98.80% */
	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		if( bound<2 )
			return Arrays.asList();
		if( x==1 && y==1 )
			return Arrays.asList(2);
		if( y==1 )
			return powerfulIntegers(y, x, bound);
		
		Set<Integer> list = new HashSet<>();
		int a = 1;
		do {
			for(int b=1;a+b<=bound;b*=y) {
				list.add(a+b);
			}
			a *= x;
		} while( a!=1 && a+1<=bound );
		
		return new ArrayList<>(list);
	}

}
