package leetcode.string;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class NumberOfSegmentsInAString {

	public static void main(String[] args) {
		String s = "Hello, my name is John";

		System.out.println(countSegments(s));
	}

	public static int countSegments(String s) {
		if( s==null || s.length()==0 )
			return 0;
		
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if( s.charAt(i)!=' ' && (i==s.length()-1 || s.charAt(i+1)==' ') ) {
				count++;
			}
		}
		return  count;
	}

}
