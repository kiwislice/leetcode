package leetcode.math;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 */
public class SelfDividingNumbers {

	public static void main(String[] args) {
		System.out.println(selfDividingNumbers(1, 22));

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> rtn = new LinkedList<>();
		for(int i=left;i<=right;i++) {
			boolean suc = true;
			int num = i, mod = 0;
			while( num>0 ) {
				mod = num%10;
				if( mod==0 || i%mod!=0 ) {
					suc = false;
					break;
				}
				num /= 10;
			}
			
			if( suc )
				rtn.add(i);
		}
		return rtn;
	}

	public static List<Integer> selfDividingNumbersByString(int left, int right) {
		List<Integer> rtn = new LinkedList<>();
		for(int i=left;i<=right;i++) {
			String s = Integer.toString(i);
			boolean suc = true;
			for(int k=s.length()-1;k>=0;k--) {
				char c = s.charAt(k);
				if( c=='0' || i%(c-'0')!=0 ) {
					suc = false;
					break;
				}
			}
			
			if( suc )
				rtn.add(i);
		}
		return rtn;
	}

}
