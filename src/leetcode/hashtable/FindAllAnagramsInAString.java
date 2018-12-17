package leetcode.hashtable;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 10 ms diffCount=跟p不同的個數，看diffCount=0來判斷是否相同
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> rtn = new LinkedList<>();
		if( s.length()<p.length() )
			return rtn;
		
		char[] cp = p.toCharArray();
		char[] cs = s.toCharArray();
		
		int[] count = new int[26];
		for(char c:cp) {
			count[c-'a']++;
		}
		int diffCount = cp.length;
		for(int i=0;i<cp.length;i++) {
			count[cs[i]-'a']--;
			diffCount -= count[cs[i]-'a']>=0?1:-1;
		}
		
		if( diffCount==0 )
			rtn.add(0);
		
		for(int i=cp.length;i<cs.length;i++) {
			count[cs[i-cp.length]-'a']++;
			diffCount -= count[cs[i-cp.length]-'a']<=0?1:-1;
			
			count[cs[i]-'a']--;
			diffCount -= count[cs[i]-'a']>=0?1:-1;
			
			if( diffCount==0 )
				rtn.add(i-cp.length+1);
		}
		return rtn;
	}

	// 18 ms psum=sum(cp)先看psum是否=0來快速失敗
	public List<Integer> findAnagramsOld(String s, String p) {
		List<Integer> rtn = new LinkedList<>();
		if( s.length()<p.length() )
			return rtn;
		
		char[] cp = p.toCharArray();
		char[] cs = s.toCharArray();
		
		int[] count = new int[26];
		int psum = 0;
		for(char c:cp) {
			count[c-'a']++;
			psum += c;
		}
		for(int i=0;i<cp.length;i++) {
			count[cs[i]-'a']--;
			psum -= cs[i];
		}
		
		if( equal(psum, count) )
			rtn.add(0);
		
		for(int i=cp.length;i<cs.length;i++) {
			count[cs[i-cp.length]-'a']++;
			psum += cs[i-cp.length];
			
			count[cs[i]-'a']--;
			psum -= cs[i];
			
			if( equal(psum, count) )
				rtn.add(i-cp.length+1);
		}
		return rtn;
	}

	public static boolean equal(int psum, int[] ar) {
		if( psum!=0 ) return false;
		for(int i:ar) {
			if( i!=0 )
				return false;
		}
		return true;
	}
	
}
