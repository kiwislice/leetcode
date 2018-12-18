package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class LongestWordInDictionary {

	public static void main(String[] args) {
//		String[] words = {"w","wo","wor","worl","world"};
		// otif
		String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};

		System.out.println(longestWord(words));
	}

	// 12 ms, faster than 88.42%
	public static String longestWord(String[] words) {
		Set<String> set = new HashSet<>(words.length);
		for(String s:words) {
			set.add(s);
		}
		
		String longestWord = "";
		for(String s:words) {
			if( s.length()<longestWord.length() )
				continue;
			if( s.length()==longestWord.length() && s.compareTo(longestWord)>0 )
				continue;
			
			boolean fail = false;
			for(int i=s.length()-1;i>0;i--) {
				String prefix = s.substring(0, i);
				if( !set.contains(prefix) ) {
					fail = true;
					break;
				}
			}
			
			if( fail ) continue;
			longestWord = s;
		}
		return longestWord;
	}

	// 32 ms, faster than 32.36%
	public static String longestWordBySortTree(String[] words) {
		Arrays.sort(words);
		
		Node root = new Node("");
		Node longestWord = new Node("");
		
		for(String s:words) {
			add(root, s, longestWord);
		}
		
		return longestWord.s;
	}

	static boolean add(Node n, String str, Node longestWord) {
		if( !str.startsWith(n.s) )
			return false;
		if( str.length()-1==n.s.length() ) {
			n.children.add(new Node(str));
			if( str.length()>longestWord.s.length() )
				longestWord.s = str;
			return true;
		}
		for(Node nc:n.children) {
			if( add(nc, str, longestWord) )
				return true;
		}
		return false;
	}
	
	static class Node {
		String s = "";
		List<Node> children = new LinkedList<>();
		
		public Node(String s) {
			this.s = s;
		}
	}
	
	// 29 ms, faster than 36.58%
	public static String longestWordBySortSet(String[] words) {
		Arrays.sort(words);
		
		Set<String> set = new HashSet<>(words.length);
		set.add("");
		String longestWord = "";
		
		for(String s:words) {
			String prefix = s.substring(0, s.length()-1);
			if( set.contains(prefix) ) {
				if( longestWord.length()<s.length() )
					longestWord = s;
				set.add(s);
			}
		}
		return longestWord;
	}

}
