package leetcode.math;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("321","456"));
		
		
	}

	public static String addStrings(String num1, String num2) {
		final int l1 = num1.length();
		final int l2 = num2.length();
		int len = Math.max(l1, l2);
		int sum = 0;
		
		StringBuilder sb = new StringBuilder(len+1);
		
		for(int i=0;i<len;i++) {
			char c1 = i<l1?num1.charAt(l1-1-i):'0';
			char c2 = i<l2?num2.charAt(l2-1-i):'0';
			sum += c1-'0'+c2-'0';
			sb.append(sum%10);
			sum /= 10;
		}
		if( sum>0 )
			sb.append(sum);
		
		sb.reverse();
		return sb.toString();
	}

}
