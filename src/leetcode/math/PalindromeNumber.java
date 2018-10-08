package leetcode.math;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1235321));
	}

	public static boolean isPalindrome(int x) {
		if( x<0 || (x%10==0 && x!=0) )
			return false;

		String s = Integer.toString(x);
		for(int i=0;i<s.length()/2;i++) {
			if( s.charAt(i)!=s.charAt(s.length()-1-i) )
				return false;
		}
        return true;
	}

	public static boolean isPalindromeByReverse(int x) {
		if( x<0 || (x%10==0 && x!=0) )
			return false;

		int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
	}

	public static boolean isPalindromeByCharArray(int x) {
		if( x<0 )
			return false;
		if( x<10 )
			return true;
		if( x<100 )
			return x%11==0;
		
		char[] car = new char[10];
		int len = 0;
		while( x!=0 ) {
			car[len++] = (char) ('0'+x%10);
			x /= 10;
		}
		
		for(int i=0;i<len/2;i++) {
			if( car[i]!=car[len-1-i] )
				return false;
		}
		return true;
	}

}
