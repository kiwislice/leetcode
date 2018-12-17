package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/
 */
public class KeyboardRow {

	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};

		System.out.println(Arrays.toString(findWords(words)));
	}

	public static String[] findWords(String[] words) {
		final int[] row = {2,1,1,2,3,2,2,2,3,2,2,2,1,1,3,3,3,3,2,3,3,1,3,1,3,1};
		List<String> list = new ArrayList<>();
		
		for(String word:words) {
			boolean suc = true;
			for(int i=1;i<word.length();i++) {
				char c1 = Character.toLowerCase(word.charAt(i-1));
				char c2 = Character.toLowerCase(word.charAt(i));
				if( row[c1-'a']!=row[c2-'a'] ) {
					suc = false;
					break;
				}
			}
			if( suc )
				list.add(word);
		}
		return list.toArray(new String[] {});
	}

}
