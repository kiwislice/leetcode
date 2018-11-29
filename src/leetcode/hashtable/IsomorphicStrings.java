package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
//		String s = "paper", t = "title";
//		String s = "abcdefghijklmnopqrstuvwxyz", t = "nopqrstuvwxyzabcdefghijklm";
//		String s = "qwertyuiop[]asdfghjkl;'\\\\zxcvbnm,./", t = "',.pyfgcrl/=aoeuidhtns-\\\\;qjkxbmwvz";
		String s = "ab", t = "aa";
		
		System.out.println(isIsomorphic(s, t));
	}

	// 1 ms
	public static boolean isIsomorphic(String s, String t) {
		int[] si = new int[256];
		int[] ti = new int[256];
		
		for(int i=s.length()-1;i>=0;i--) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if( si[sc]!=ti[tc] )
				return false;
			
			si[sc] = i;
			ti[tc] = i;
		}
		return true;
	}

	// 10 ms
	public static boolean isIsomorphicBy1Map(String s, String t) {
		Map<Character, Character> stmap = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if( stmap.containsKey(sc) && stmap.get(sc)==tc )
				continue;
			if( stmap.containsKey(sc) || stmap.containsValue(tc) )
				return false;
			
			stmap.put(sc, tc);
		}
		return true;
	}

	// 39 ms
	public static boolean isIsomorphicBy2Map(String s, String t) {
		Map<Character, Character> stmap = new HashMap<>();
		Map<Character, Character> tsmap = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if( stmap.containsKey(sc) && stmap.get(sc)!=tc )
				return false;
			if( tsmap.containsKey(tc) && tsmap.get(tc)!=sc )
				return false;
			if( stmap.containsKey(sc) )
				continue;
			
			stmap.put(sc, tc);
			tsmap.put(tc, sc);
		}
		return true;
	}

}
