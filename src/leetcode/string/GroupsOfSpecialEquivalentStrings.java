package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class GroupsOfSpecialEquivalentStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSpecialEquivGroups(String[] A) {
		Set<Key> set = new HashSet<>();
		for(String s:A) {
			set.add(new Key(s));
		}
		return set.size();
	}

	public static boolean specialEquiv(String s1, String s2) {
		int[][] k1 = key(s1);
		int[][] k2 = key(s2);
		return Objects.deepEquals(k1, k2);
	}
	
	static class Key {
		
		final int[][] k;
		
		Key(String s){
			this.k = key(s);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.deepHashCode(k);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (!Arrays.deepEquals(k, other.k))
				return false;
			return true;
		}
		
	}
	
	public static int[][] key(String s) {
		if( s==null ) return null;
		
		int[][] rtn = new int[2][26];
		for(int i=0;i<s.length();i+=2) {
			rtn[0][s.charAt(i)-'a']++;
		}
		for(int i=1;i<s.length();i+=2) {
			rtn[1][s.charAt(i)-'a']++;
		}
		return rtn;
	}
	
}
