package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/
 */
public class UniqueMorseCodeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static final String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	
	public int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		
		for(String word:words) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<word.length();i++) {
				sb.append(codes[word.charAt(i)-'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

}
