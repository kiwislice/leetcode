package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

	public static void main(String[] args) {

	}
	
	static final Map<Character, Integer> m;
	static {
		m = new HashMap<>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
	}
	
	public int romanToInt(String s) {
		int rtn = 0;
		int lastNum = 0;
		
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			int cNum = m.get(c);
			if( cNum>=lastNum ) {
				rtn += cNum;
				lastNum = cNum;
			}
			else {
				rtn -= cNum;
			}
		}
		return rtn;
	}

}
