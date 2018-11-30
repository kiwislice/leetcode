package leetcode.hashtable;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		// 7
		String s = "abccccdd";

		System.out.println(longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {
		int[] count = new int[128];
		char[] cs = s.toCharArray();
		for(char c:cs) {
			count[c]++;
		}
		
		boolean hasOdd = false;
		int max = 0;
		for(int i=0;i<count.length;i++) {
			if( count[i]%2==0 ) {
				max += count[i]; 
			}
			else {
				hasOdd = true;
				max += count[i]-1;
			}
		}
		return hasOdd?max+1:max;
	}

}
