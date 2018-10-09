package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(([]){})"));
	}

	public static boolean isValid(String s) {
		if( s==null || s.length()==0 )
			return true;
		
		Deque<Character> stack = new LinkedList<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			boolean isL = c=='(' || c=='[' || c=='{';
			boolean isR = !isL && (c==')' || c==']' || c=='}');
			
			if( isL ) {
				stack.addLast(c);
			}	
			else if( isR ) {
				char left = stack.isEmpty()?'%':stack.removeLast();
				boolean valid = left=='(' && c==')';
				valid |= left=='[' && c==']';
				valid |= left=='{' && c=='}';
				if( !valid )
					return false;
			}
		}
		
		return stack.isEmpty();
	}

}
