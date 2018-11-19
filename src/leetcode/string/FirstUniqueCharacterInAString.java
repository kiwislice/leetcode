package leetcode.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		String s = "leetcode";

		System.out.println(firstUniqChar(s));
	}

	// 23 ms
	public static int firstUniqChar(String s) {
		if( s==null || s.length()==0 )
			return -1;
		if( s.length()==1 )
			return 0;
		
		boolean[] found = new boolean[26];
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if( found[c-'a'] )
				continue;
			if( s.indexOf(c, i+1)==-1 )
				return i;
			found[c-'a'] = true;
		}
		return -1;
	}

	// 18 ms
	public static int firstUniqCharOld(String s) {
		if( s==null || s.length()==0 )
			return -1;
		if( s.length()==1 )
			return 0;
		
		int[][] count = new int[26][2];
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			count[c-'a'][0]++;
			if( count[c-'a'][0]==1 )
				count[c-'a'][1] = i;
		}
		int minIndex = Integer.MAX_VALUE;
		for(int i=0;i<count.length;i++) {
			if( count[i][0]==1 )
				minIndex = Math.min(minIndex, count[i][1]);
		}
		return minIndex==Integer.MAX_VALUE?-1:minIndex;
	}

}
