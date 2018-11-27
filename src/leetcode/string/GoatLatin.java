package leetcode.string;

/**
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {

	public static void main(String[] args) {
		// "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
		String S = "I speak Goat Latin";

		System.out.println(toGoatLatin(S));
	}

	public static String toGoatLatin(String S) {
		StringBuilder sb = new StringBuilder(S.length()*2);
		StringBuilder sufix = new StringBuilder();
		StringBuilder aa = new StringBuilder();
		aa.append('a');
		
		boolean start = true;
		for(int i=0;i<S.length();i++) {
			char c = S.charAt(i);
			
			if( c==' ' ) {
				sb.append(sufix);
				sb.append(aa);
				sb.append(c);
				sufix.setLength(0);
				start = true;
				aa.append('a');
			}
			else if( start ) {
				start = false;
				if( c=='A' || c=='E' || c=='I' || c=='O' || c=='U' 
						|| c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ) {
					sb.append(c);
					sufix.append("ma");
				}
				else {
					sufix.append(c);
					sufix.append("ma");
				}
			}
			else {
				sb.append(c);
			}
		}
		
		sb.append(sufix);
		sb.append(aa);
		
		return sb.toString();
	}

}
