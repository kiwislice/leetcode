package leetcode.bitmanipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

	public static void main(String[] args) {
		String s = "a1b2";

		System.out.println(letterCasePermutation(s));
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> list = new LinkedList<>();
		permutation(S.toCharArray(), 0, "", list);
		return list;
	}

	public static void permutation(char[] s, int from, String sb, List<String> rtn) {
		if( from==s.length ) {
			rtn.add(sb);
			return ;
		}
		
		char changeSizeC = changeSize(s[from]);
		permutation(s, from+1, sb+s[from], rtn);
		
		if( s[from]!=changeSizeC ) {
			permutation(s, from+1, sb+changeSizeC, rtn);
		}
	}
	
	public static char changeSize(char c) {
		if( c<='9' ) return c;
		return (char) (c ^ 0b0010_0000);
	}
	
}
