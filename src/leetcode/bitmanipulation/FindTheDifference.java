package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char findTheDifference(String s, String t) {
		int rtn = 0;
		for(char c:s.toCharArray())
			rtn ^= c;
		for(char c:t.toCharArray())
			rtn ^= c;
		return (char) rtn;
	}

}
