package leetcode.math;

public class NthDigit {

	public static void main(String[] args) {
//		for(int i=1;i<220;i++)
//			System.out.print(findNthDigit(i));
//		System.out.println(findNthDigit(100));
//		System.out.println(findNthDigit(10));
//		System.out.println(findNthDigit(11));
//		// 2
//		System.out.println(findNthDigit(30));
//		// 3
//		System.out.println(findNthDigit(1000));
		// 1
		System.out.println(findNthDigit(1000000000));
	}

	public static int findNthDigit(int n) {
		if( n<10 )
			return n;
		
		int digit = 1;
		long count = 10;
		int base = 1;
		
		while(n>=count) {
			n -= count;
			base = (int) Math.pow(10, ++digit-1);
			count = digit*base*9L;
		}
		
		int num = n/digit + base;
		int posi = n%digit;
		
		for(int i=0;i<digit-posi-1;i++) {
			num /= 10;
		}
		return num%10;
	}
	
}
