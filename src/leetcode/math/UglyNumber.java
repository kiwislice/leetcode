package leetcode.math;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isUgly(int num) {
		if( num<=0 )
			return false;
		if( num<7 )
			return true;
		
		// remove 2
		while((num&1)==0) {
			num >>= 1;
		}
		// remove 3
		while(num%3==0) {
			num /= 3;
		}
		// remove 5
		while(num%5==0) {
			num /= 5;
		}
		
		return num==1;
	}

}
