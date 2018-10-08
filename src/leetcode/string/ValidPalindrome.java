package leetcode.string;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome(".,"));
	}
	
	public static boolean isPalindrome(String s) {
		if( s==null )
			return false;
		if( "".equals(s.trim()) )
			return true;

		int left = 0;
		int right = s.length()-1;
		
		while( left<right ) {
			// find left
			while( !isAlphaNum(s.charAt(left)) && left<right ) {
				left++;
			}
			// find right
			while( !isAlphaNum(s.charAt(right)) && left<right ) {
				right--;
			}
			if( left>right )
				return false;
			
//			System.out.println(s.charAt(left)+"!="+s.charAt(right));
			if( !eq(s.charAt(left++), s.charAt(right--)) )
				return false;
		}
        return true;
	}

	public static boolean eq(char a, char b) {
		boolean suc = a==b;
		suc |= a>='A' && a+32==b;
		suc |= b>='A' && b+32==a;
		return suc;
	}
	
	public static boolean isAlphaNum(char c) {
		boolean suc = c>='0' && c<='9';
		suc |= c>='a' && c<='z';
		suc |= c>='A' && c<='Z';
		return suc;
	}

}
