package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseStringII {

	public static void main(String[] args) {
		// input 8 ans "gfedcba"
//		String s = "abcdefg";
		// input 2 ans "bacd"
		String s = "abcd";

		System.out.println(reverseStr(s, 2));
	}

	public static String reverseStr(String s, int k) {
		if( s==null || s.length()<=1 )
			return s;
		
		final int k2 = k<<1;
		int index = 0;
		
		char[] rtn = s.toCharArray();
		while(index+k2<=s.length()) {
			reverse(rtn, index, k);
			index += k2;
		}
		
		int mod = s.length()%k2;
		if( mod>0 ) {
			reverse(rtn, index, Math.min(mod, k));
		}
		return new String(rtn);
	}

	private static void reverse(char[] cs, int start, int len) {
		for(int i=0;i<len>>1;i++) {
			char c = cs[start+i];
			cs[start+i] = cs[start+len-1-i];
			cs[start+len-1-i] = c;
		}
	}
	
}
