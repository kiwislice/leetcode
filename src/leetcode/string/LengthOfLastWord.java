package leetcode.string;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("aaabbb "));
	}
	
	public static int lengthOfLastWord(String s) {
		int startAlpha = -1;
		int endAlpha = -1;
		
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			boolean isAlpha = c>='a' && c<='z';
			isAlpha |= c>='A' && c<='Z';
			
			if( isAlpha && endAlpha==-1 ) {
				endAlpha = i;
			}
			else if( !isAlpha && endAlpha>-1 && startAlpha==-1 ) {
				startAlpha = i+1;
				break;
			}
		}
		
		if( endAlpha>-1 )
			return endAlpha-(startAlpha==-1?0:startAlpha)+1;
		return 0;
	}

}
