package leetcode.array;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int sum = 1;
		for(int i=digits.length-1;i>=0;i--) {
			sum += digits[i];
			digits[i] = sum%10;
			sum /= 10;
		}
		
		boolean sum1 = sum>0;
		int[] rtn = new int[sum1?digits.length+1:digits.length];
		System.arraycopy(digits, 0, rtn, sum1?1:0, digits.length);
		if( sum1 )
			rtn[0] = sum;
		
		return rtn;
	}

}
