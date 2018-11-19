package leetcode.string;

public class ReverseString {

	public static void main(String[] args) {
		// "amanaP :lanac a ,nalp a ,nam A"
		String s = "A man, a plan, a canal: Panama";
		
		System.out.println(reverseString(s));
	}

	// 2 ms
	public static String reverseString(String s) {
		if( s==null || s.length()<=1 )
			return s;
		
		char[] rtn = s.toCharArray();
		for(int i=0;i<rtn.length/2;i++) {
			char c = rtn[rtn.length-1-i];
			rtn[rtn.length-1-i] = rtn[i];
			rtn[i] = c;
		}
		return new String(rtn);
	}

	// 3 ms
	public static String reverseStringByCharArray(String s) {
		if( s==null || s.length()<=1 )
			return s;
		
		char[] rtn = new char[s.length()];
		for(int i=0;i<s.length();i++) {
			rtn[i] = s.charAt(s.length()-1-i);
		}
		return new String(rtn);
	}

	// 4 ms
	public static String reverseStringByStringBuilder(String s) {
		if( s==null || s.length()<=1 )
			return s;
		
		StringBuilder sb = new StringBuilder(s.length());
		for(int i=0;i<s.length();i++) {
			sb.append(s.charAt(s.length()-1-i));
		}
		return sb.toString();
	}

}
