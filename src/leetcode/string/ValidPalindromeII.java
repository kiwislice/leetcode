package leetcode.string;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

	public static void main(String[] args) {
//		String s = "aba";
//		String s = "abca";
		String s = "abc";

		System.out.println(validPalindrome(s));
	}

	public static boolean validPalindrome(String s) {
		int L = 0;
		int R = s.length()-1;
		
		while(L<R) {
			if( s.charAt(L)==s.charAt(R) ) {
				L++;
				R--;
				continue;
			}
			return palindrome(s, L+1, R) || palindrome(s, L, R-1);
		}
		return true;
	}

	public static boolean palindrome(String s, int L, int R) {
		while(L<R) {
			if( s.charAt(L)==s.charAt(R) ) {
				L++;
				R--;
				continue;
			}
			return false;
		}
		return true;
	}
	
}
