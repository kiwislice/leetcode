package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAStringIII {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";

		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		char[] cs = s.toCharArray();
		int L = 0, R = 0;
		while( L<cs.length ) {
			R = s.indexOf(' ', L+1);
			R = R==-1?cs.length-1:R-1;
			reverse(cs, L, R);
			L = R+2;
		}
		return new String(cs);
	}

	private static void reverse(char[] cs, int s, int e) {
		final int len = e-s+1;
		for(int i=0;i<len/2;i++) {
			char c = cs[s+i];
			cs[s+i] = cs[s+len-1-i];
			cs[s+len-1-i] = c;
		}
	}
	
}
