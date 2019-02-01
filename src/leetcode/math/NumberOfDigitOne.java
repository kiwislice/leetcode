package leetcode.math;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class NumberOfDigitOne {

	public static void main(String[] args) {
		int n = 200;

		System.out.println(countDigitOne(n));
	}

	/** 0 ms, faster than 100.00% */
	public static int countDigitOne(int n) {
		final long x = n;
		// <=的個位數1的數量
		int sum = (int) ((x+9)/10);
		long pow1 = 10;
		long pow8 = 80;
		long pow10 = 100;
		
		// 每次迴圈就是計算10位數的1的數量、100位數的1的數量、...
		for(int i=0;i<10;i++) {
			// 有完整涵蓋一整塊的數量，EX：200有完整涵蓋百位數一整塊
			long full = (x+pow8)/pow10;
			// 有缺陷的數量，EX：146的百位數1只有47個
			long mod = (n%pow10)/pow1==1?n%pow1+1:0;
			sum += full*pow1+mod;
			
			pow1 *= 10;
			pow8 *= 10;
			pow10 *= 10;
		}
		
//		long x1 = (x+9)/10;
//		long x10 = (x+80)/100+((n%100)/10==1?n%10+1:0);
//		long x100 = (x+800)/1000+((n%1000)/100==1?n%100+1:0);
		return sum;
	}

}
