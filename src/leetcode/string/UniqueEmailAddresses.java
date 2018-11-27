package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for(String email:emails) {
			StringBuilder sb = new StringBuilder(email.length());
			for(int i=0;i<email.length();i++) {
				char c = email.charAt(i);
				if( c=='+' || c=='@' )
					break;
				if( c!='.' )
					sb.append(c);
			}
			sb.append(email.substring(email.indexOf('@')));
			set.add(sb.toString());
		}
		return set.size();
	}

}
