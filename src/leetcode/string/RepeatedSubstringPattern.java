package leetcode.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
//		String s = "abab";
//		String s = "ababa";
		String s = "ababaababa";

		System.out.println(repeatedSubstringPattern(s));
	}

	// 84 ms
	public boolean repeatedSubstringPatternByMagic(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
	
	// 39 ms
	public static boolean repeatedSubstringPattern(String s) {
		if( s==null || s.length()<=1 )
			return false;
		
		int len = 1;
		int max = s.length()/2;
		while(len<=max) {
			if( isRepeat(s, len) ) {
				return true;
			}
			else {
				len++;
				while(len<=max && s.length()%len!=0) {
					len++;
				}
			}
		}
		return false;
	}
	
	public static boolean isRepeat(String s, int patternLen) {
		for(int i=patternLen;i<s.length();i++) {
			if( s.charAt(i)!=s.charAt(i%patternLen) )
				return false;
		}
		return true;
	}
	
}
