package leetcode.string;

/**
 * https://leetcode.com/problems/to-lower-case/
 */
public class ToLowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1 ms
	public String toLowerCase(String str) {
		if( str==null )
			return str;
		
		final int diff = -'A'+'a';
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++) {
			if( cs[i]>='A' && cs[i]<='Z' ) {
				cs[i] = (char) (cs[i]+diff);
			}
		}
		return new String(cs);
	}

	// 1 ms
	public String toLowerCaseByCharacterLib(String str) {
		if( str==null )
			return str;
		
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++) {
			cs[i] = Character.toLowerCase(cs[i]);
		}
		return new String(cs);
	}

	// 0 ms
	public String toLowerCaseByLib(String str) {
		if( str==null )
			return str;
		return str.toLowerCase();
	}

}
