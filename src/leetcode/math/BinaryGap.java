package leetcode.math;

/**
 * https://leetcode.com/problems/binary-gap/
 */
public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(binaryGap(5));

	}

	public static int binaryGap(int N) {
		int lastOne = -1;
		int max = 0;
		while(N>0) {
			if( (N&1)==1 ) {
				if( ++lastOne>0 )
					max = Math.max(max, lastOne);
				lastOne = 0;
			}
			else {
				if( lastOne>=0 )
					lastOne++;
			}
			N >>= 1;
		}
		return max;
	}

}
