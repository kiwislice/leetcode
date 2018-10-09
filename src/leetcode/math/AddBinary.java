package leetcode.math;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("0111","1100"));
	}

	public static String addBinary(String a, String b) {
		final int aLen = a.length();
		final int bLen = b.length();
		final int maxLen = Math.max(aLen, bLen);
		
		char[] rtn = new char[maxLen+1];
		int sum = 0;
		for(int i=0;i<maxLen;i++) {
			char ac = i>=aLen?'0':a.charAt(aLen-i-1);
			char bc = i>=bLen?'0':b.charAt(bLen-i-1);
			
			sum += ac-'0'+bc-'0';
			rtn[maxLen-i] = (char) (sum%2 + '0');
			sum /= 2;
		}
		if( sum!=0 )
			rtn[0] = '1';
		
		return new String(rtn, sum==0?1:0, sum==0?maxLen:maxLen+1);
	}

}
