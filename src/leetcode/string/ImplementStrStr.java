package leetcode.string;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {

	public static void main(String[] args) {
		String haystack = "hello", needle = "ll";
//		String haystack = "aaaaa", needle = "bba";
		
		
		System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		if( needle.length()>haystack.length() )
			return -1;
		if( needle.length()==0 )
			return 0;
		
		i:for(int i=0;i<=haystack.length()-needle.length();i++) {
			for(int j=0;j<needle.length();j++) {
				if( haystack.charAt(i+j)!=needle.charAt(j) )
					continue i;
			}
			return i;
		}
		return -1;
	}

}
