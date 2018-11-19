package leetcode.string;

import java.util.Arrays;

public class StringCompression {

	public static void main(String[] args) {
//		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] chars = {'a','b','c'};

		System.out.println(compressByTwoPoint(chars));
		System.out.println(Arrays.toString(chars));
	}

	// 4 ms
	public static int compressByTwoPoint(char[] chars) {
		if( chars==null || chars.length==0 )
			return 0;
		if( chars.length==1 )
			return 1;
		
		int writeIndex = 0;
		for(int i=0;i<chars.length;i++) {
			char c = chars[i];
			int count = 1;
			
			while(i<chars.length-1 && chars[i+1]==c) {
				count++;
				i++;
			}
			
			chars[writeIndex++] = c;
			if( count>1 ) {
				for(char ch:Integer.toString(count).toCharArray()) {
					chars[writeIndex++] = ch;
				}
			}
		}
		
		return writeIndex;
	}

	// 4 ms
	public static int compress(char[] chars) {
		if( chars==null || chars.length==0 )
			return 0;
		if( chars.length==1 )
			return 1;
		
		char lastC = chars[0];
		int count = 1;
		int writeIndex = 0;
		for(int i=1;i<chars.length;i++) {
			if( chars[i]==lastC )
				count++;
			else {
				chars[writeIndex++] = lastC;
				if( count==1 ) {
				}
				else if( count<10 ) {
					chars[writeIndex++] = (char) (count+'0');
				}
				else {
					String s = String.valueOf(count);
					for(int j=0;j<s.length();j++)
						chars[writeIndex++] = s.charAt(j);
				}
				lastC = chars[i];
				count = 1;
			}
		}
		
		chars[writeIndex++] = lastC;
		if( count==1 ) {
		}
		else if( count<10 ) {
			chars[writeIndex++] = (char) (count+'0');
		}
		else {
			String s = String.valueOf(count);
			for(int j=0;j<s.length();j++)
				chars[writeIndex++] = s.charAt(j);
		}
		
		return writeIndex;
	}

}
