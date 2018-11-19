package leetcode.string;

import java.util.Objects;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class LongestUncommonSubsequenceI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLUSlength(String a, String b) {
		if( Objects.equals(a, b) )
			return -1;
		if( a==null ^ b==null )
			return a==null?b.length():a.length();
		return Math.max(a.length(), b.length());
	}

}
