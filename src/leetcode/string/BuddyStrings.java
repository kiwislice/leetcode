package leetcode.string;

/**
 * https://leetcode.com/problems/buddy-strings/
 */
public class BuddyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean buddyStrings(String A, String B) {
		if( A==null || B==null || A.length()!=B.length() )
			return false;
		
		boolean aHasRepeatChar = false;
		int diffCount = 0;
		int[] aCharCount = new int[26];
		int[] diffIndex = {-1, -1};
		
		for(int i=0;i<A.length();i++) {
			char ac = A.charAt(i);
			
			if( !aHasRepeatChar ) {
				aCharCount[ac-'a']++;
				if( aCharCount[ac-'a']>=2 )
					aHasRepeatChar = true;
			}
			
			if( ac!=B.charAt(i) ) {
				diffCount++;
				if( diffCount>2 )
					return false;
				diffIndex[diffCount-1] = i;
			}
		}
		
		if( diffCount==0 ) {
			return aHasRepeatChar;
		}
		if( diffCount==2 ) {
			return A.charAt(diffIndex[0])==B.charAt(diffIndex[1]) 
					&& A.charAt(diffIndex[1])==B.charAt(diffIndex[0]);
		}
		return false;
	}

}
