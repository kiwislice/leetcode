package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

	public static void main(String[] args) {

	}

	public boolean wordPattern(String pattern, String str) {
		List<String> strs = split(str);
		if( pattern.length()!=strs.size() )
			return false;
			
		Map<Character, Integer> pm = new HashMap<>();
		Map<String, Integer> sm = new HashMap<>();
		for(int i=0;i<pattern.length();i++) {
			char ps = pattern.charAt(i);
			String ss = strs.get(i);
			
			int pi = pm.getOrDefault(ps, -1);
			int si = sm.getOrDefault(ss, -1);
			
			if( pi!=si )
				return false;
			
			pm.put(ps, i);
			sm.put(ss, i);
		}
		return true;
	}

	public static List<String> split(String str) {
		List<String> rtn = new ArrayList<>();
		int L = 0;
		while(true) {
			int R = str.indexOf(' ', L+1);
			if( R<0 ) {
				rtn.add(str.substring(L));
				break;
			} else {
				rtn.add(str.substring(L, R));
			}
			L = R+1;
		}
		return rtn;
	}
	
}
