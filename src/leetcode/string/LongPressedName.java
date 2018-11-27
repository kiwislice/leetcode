package leetcode.string;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isLongPressedName(String name, String typed) {
		int nI = 0;
		char nC = name.charAt(nI);
		
		int tI = 0;
		char tC = typed.charAt(tI);
		
		while(nC==tC) {
			int nCount = count(name, nI);
			int tCount = count(typed, tI);
			if( nCount>tCount )
				return false;
			
			nI += nCount;
			tI += tCount;
			if( nI==name.length() && tI==typed.length() )
				return true;
			if( nI==name.length() || tI==typed.length() )
				return false;
			
			nC = name.charAt(nI);
			tC = typed.charAt(tI);
		}
		return false;
	}

	public static int count(String s, int fromInclude) {
		if( fromInclude>=s.length() ) return 0;
		
		char c = s.charAt(fromInclude++);
		int count = 1;
		while(fromInclude<s.length() && c==s.charAt(fromInclude)) {
			count ++;
			fromInclude++;
		}
		return count;
	}
	
}
