package leetcode.string;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings {

	public static void main(String[] args) {
		// 3
		String s = "00110";

		System.out.println(countBinarySubstrings(s));
	}

	public static int countBinarySubstrings(String s) {
		if( s==null || s.length()<=1 )
			return 0;
		
		char[] cs = {'0','1'};
		int targetIndex = s.charAt(0)=='0'?1:0;
		
		int rtn = 0;
		int countL = 0, countR = 0;
		int L = 0, R = 0;
		boolean findEnd = false;
		
		while(!findEnd) {
			R = s.indexOf(cs[targetIndex], R+1);
			targetIndex = (targetIndex+1)%cs.length;
			if( R==-1 ) {
				findEnd = true;
				R = s.length();
			}
			countR = R-L;
			
			rtn += Math.min(countL, countR);
			
			countL = countR;
			L = R;
		}
		return rtn;
	}

}
