package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

	public static void main(String[] args) {
//		String ransomNote = "aa", magazine = "ab";
		String ransomNote = "fihjjjjei", magazine = "hjibagacbhadfaefdjaeaebgi";
		
		System.out.println(canConstruct(ransomNote, magazine));
	}

	// 10 ms
	public static boolean canConstruct(String ransomNote, String magazine) {
		if( ransomNote==null || ransomNote.length()==0 )
			return true;
		if( ransomNote.length()>magazine.length() )
			return false;
		
		int[] index = new int[26];
		for(int i=0;i<ransomNote.length();i++) {
			char c = ransomNote.charAt(i);
			int found = magazine.indexOf(c, index[c-'a']);
			if( found==-1 ) return false;
			index[c-'a'] = found+1;
		}
		return true;
	}

	// 60 ms
	public boolean canConstructByMap(String ransomNote, String magazine) {
		if( ransomNote==null || ransomNote.length()==0 )
			return true;
		if( ransomNote.length()>magazine.length() )
			return false;
		
		Map<Character, Integer> mag = new HashMap<>();
		for(int i=0;i<magazine.length();i++) {
			char c = magazine.charAt(i);
			mag.put(c, mag.getOrDefault(c, 0)+1);
		}
		
		for(int i=0;i<ransomNote.length();i++) {
			char c = ransomNote.charAt(i);
			int count = mag.getOrDefault(c, 0);
			if( count==0 ) return false;
			mag.put(c, count-1);
		}
		return true;
	}

}
