package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String S = "a-bC-dEf-ghIj";

		System.out.println(reverseOnlyLetters(S));
	}

	public static String reverseOnlyLetters(String S) {
		char[] cs = S.toCharArray();
		int L = 0, R = cs.length-1;		
		
		while(L<R) {
			if( isAlpha(cs[L]) && isAlpha(cs[R]) ) {
				char c = cs[L];
				cs[L] = cs[R];
				cs[R] = c;
				
				L++;
				R--;
			}
			else {
				while( L<R && !isAlpha(cs[L]) ) {L++;}
				while( L<R && !isAlpha(cs[R]) ) {R--;}
			}
		}
		return new String(cs);
	}

	public static boolean isAlpha(char c) {
		return (c>='a' && c<='z') || (c>='A' && c<='Z');
	}
	
}
