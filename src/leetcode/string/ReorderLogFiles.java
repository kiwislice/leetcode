package leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-log-files/
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

		System.out.println(Arrays.toString(reorderLogFiles(logs)));
	}

	// 8 ms
	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int i1 = s1.indexOf(' ')+1;
				char c1 = s1.charAt(i1);
				boolean numlog1 = c1>='0' && c1<='9';
				
				int i2 = s2.indexOf(' ')+1;
				char c2 = s2.charAt(i2);
				boolean numlog2 = c2>='0' && c2<='9';
				
				if( numlog1 && numlog2 )
					return 0;
				if( numlog1 ^ numlog2 )
					return numlog1?1:-1;
				if( c1!=c2 )
					return c1-c2;
				
				return s1.substring(i1).compareTo(s2.substring(i2));
			}
		});
		return logs;
	}

	// 52 ms
	public static String[] reorderLogFilesOld(String[] logs) {
		Arrays.sort(logs, (s1, s2) -> {
			int i1 = s1.indexOf(' ')+1;
			char c1 = s1.charAt(i1);
			boolean numlog1 = c1>='0' && c1<='9';
			
			int i2 = s2.indexOf(' ')+1;
			char c2 = s2.charAt(i2);
			boolean numlog2 = c2>='0' && c2<='9';
			
			if( numlog1 && numlog2 )
				return 0;
			if( numlog1 ^ numlog2 )
				return numlog1?1:-1;
			
			while( i1<s1.length() && i2<s2.length() ) {
				c1 = s1.charAt(i1++);
				c2 = s2.charAt(i2++);
				if( c1!=c2 )
					return c1-c2;
			}
			return s1.length()-s2.length();
		});
		return logs;
	}

}
