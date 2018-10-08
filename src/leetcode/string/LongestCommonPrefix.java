package leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));

	}

	public static String longestCommonPrefix(String[] strs) {
		if( strs==null || strs.length==0 )
			return "";
		
		String prefix = strs[0];
		for(int i=1;i<strs.length;i++) {
			if( prefix.length() > strs[i].length() )
				prefix = prefix.substring(0, strs[i].length());
			
			for(int posi=0;posi<prefix.length();posi++) {
				if( prefix.charAt(posi)!=strs[i].charAt(posi) ) {
					if( posi==0 )
						return "";
					else {
						prefix = prefix.substring(0, posi);
						break;
					}	
				}
			}
		}
		return prefix;
	}

}
