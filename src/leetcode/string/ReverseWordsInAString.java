package leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		System.out.println(reverseWords(" 1 23  45  6  5 "));

	}

	public static String reverseWords(String s) {
		if( s==null )
			return null;
		
		String[] ar = s.split(" ");
		if( ar.length==0 )
			return "";
		
		StringBuilder sb = new StringBuilder("");
		for(int i=ar.length-1;i>=0;i--) {
			if( "".equals(ar[i]) )
				continue;
			sb.append(ar[i]);
			if( i>0 )
				sb.append(" ");
		}
		return sb.toString().trim();
	}

}
