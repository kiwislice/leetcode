package leetcode.string;

/**
 * https://leetcode.com/problems/count-and-say/
 * 1,11,21,1211,111221,...
 */
public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(28));
//		for(int i=1;i<=30;i++)
//			System.out.println(countAndSay(i));
	}
	
	public static String countAndSay(int n) {
		if( n==1 )
			return "1";
		if( n==2 )
			return "11";
		
		String rtn = "11";
		for(int i=0;i<n-2;i++) {
			rtn = next(rtn);
		}
		return rtn;
	}
	
	public static String next(String s) {
		int count = 1;
		char lastC = s.charAt(0);
		StringBuilder rtn = new StringBuilder();
		for(int i=1;i<s.length();i++) {
			char curC = s.charAt(i);
			if( curC==lastC ) {
				count++;
			}
			else {
				rtn.append(count);
				rtn.append(lastC);
				count = 1;
				lastC = curC;
			}
		}
		rtn.append(count);
		rtn.append(lastC);
		return rtn.toString();
	}

}
