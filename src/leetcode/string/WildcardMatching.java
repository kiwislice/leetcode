package leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {

	public static void main(String[] args) {
//		System.out.println(splitByStar("164"));
//		System.out.println(splitByStar("1641**"));
//		System.out.println(splitByStar("**16541"));
//		System.out.println(splitByStar("68***4?23*1***"));
		
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("", ""));
		System.out.println(isMatch("aaaa", "***a"));
	}
	
	public static boolean isMatch(String s, String p) {
		if( s==null || p==null )
			return false;
		if( p.length()==0 )
			return s.length()==0;
		
		String[] ps = splitByStar(p);
		if( ps.length==1 ) {
			if( "*".equals(ps[0]) )
				return true;
			return sameWithQ(s, 0, ps[0]) && s.length()==p.length();
		}
		
		boolean starOnHead = "*".equals(ps[0]);
		int index = 0;
		if( !starOnHead ) {
			if( !sameWithQ(s, 0, ps[0]) )
				return false;
			else
				index = ps[0].length();
		}
		
		for(int i=starOnHead?1:2;i<ps.length;i+=2) {
			int newindex = sameWithQUntilEnd(s, index, ps[i]);
			if( newindex==-1 )
				return false;
			index = newindex + ps[i].length();
		}
		
		if( !"*".equals(ps[ps.length-1]) ) {
			index = s.length() - ps[ps.length-1].length();
			return sameWithQ(s, index, ps[ps.length-1]);
		}
		return true;
	}
	
	public static int sameWithQUntilEnd(String s, int startS, String p) {
		for(int i=startS;i<=s.length()-p.length();i++) {
			if( sameWithQ(s, i, p) ) {
				return i;
			}
		}
		return -1;
	}
	
	public static String[] splitByStar(String p) {
		List<String> rtn = new LinkedList<>();
		
		int status = -1; // 0:char, 1:star
		int start = 0;
		for(int i=0;i<p.length();i++) {
			if( p.charAt(i)=='*' ) {
				if( status==0 ) {
					rtn.add(p.substring(start, i));
				}
				if( status!=1 ) {
					rtn.add("*");
					status = 1;
				}
			}
			else {
				if( status!=0 ) {
					status = 0;
					start = i;
				}
			}
		}
		
		if( status==0 ) {
			rtn.add(p.substring(start));
		}
		
		String[] ar = new String[rtn.size()];
		return rtn.toArray(ar);
	}
	
	public static boolean sameWithQ(String s, int startS, String p) {
		if( startS + p.length() > s.length() )
			return false;
		
		for(int i=0;i<p.length();i++) {
			if( p.charAt(i)=='?' )
				continue;
			if( s.charAt(startS+i)!=p.charAt(i) )
				return false;
		}
		return true;
	}
	
}
