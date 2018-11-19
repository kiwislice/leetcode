package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfAString {
	
	public static void main(String[] args) {
		String s = "hello";

		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		if( s==null || s.length()<=1 )
			return s;
		
		char[] rtn = s.toCharArray();
		int L = 0;
		int R = rtn.length-1;
		
		while(L<R) {
			if( isVowels(rtn[L]) && isVowels(rtn[R]) ) {
				char c = rtn[L];
				rtn[L] = rtn[R];
				rtn[R] = c;
				
				L++;
				R--;
			}
			else {
				while( !isVowels(rtn[L]) && L<R ) {L++;}
				while( !isVowels(rtn[R]) && L<R ) {R--;}
			}
		}
		return new String(rtn);
	}

	public static boolean isVowels(char c) {
		Character.toLowerCase(c);
		return c=='a' || c=='e' ||c=='i' ||c=='o' || c=='u'
				|| c=='A' || c=='E' ||c=='I' ||c=='O' || c=='U';
	}
	
}
