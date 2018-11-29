package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

	public static void main(String[] args) {
		int L = 842, R = 888;
//		int L = 5, R = 10;

		System.out.println(countPrimeSetBits(L, R));
	}

	// 10 ms
	public static int countPrimeSetBitsByMagic(int L, int R) {
		int count = 0;
		for(int i=L;i<=R;i++) {
			// 665772 = 10100010100010101100
			if( ((665772>>Integer.bitCount(i))&1)==1 )
				count++;
		}
		return count;
	}

	// 10 ms
	public static int countPrimeSetBits(int L, int R) {
		int count = 0;
		for(int i=L;i<=R;i++) {
			int bitCount = Integer.bitCount(i); 
			if( isPrime(bitCount) )
				count++;
		}
		return count;
	}

	// 40 ms
	public static int countPrimeSetBitsOld(int L, int R) {
		int rowNum = rowNum(L);
		int colNum = L - (1<<rowNum);
		
		int[] bitCountAr = {1};
		for(int i=0;i<rowNum;i++)
			bitCountAr = bitCountAr(bitCountAr);
		
		int count = 0;
		while(L<=R) {
			if( isPrime(bitCountAr[colNum]) ) {
				count++;
			}
			
			L++;
			colNum++;
			if( colNum==bitCountAr.length ) {
				bitCountAr = bitCountAr(bitCountAr);
				colNum = 0;
			}
		}
		return count;
	}

	public static int rowNum(int n) {
		int count = 0;
		while(n>0) {
			count++;
			n >>>= 1;
		}
		return count-1;
	}
	
	public static boolean isPrime(int n) {
		return n==2 || n==3 || n==5 || n==7 || n==11 || n==13 
				|| n==17 || n==19 || n==23 || n==29 || n==31;
	}
	
	public static int[] bitCountAr(int[] ar) {
		int[] rtn = new int[ar.length*2];
		System.arraycopy(ar, 0, rtn, 0, ar.length);
		for(int i=0;i<ar.length;i++)
			rtn[i+ar.length] = ar[i]+1;
		return rtn;
	}
	
}
