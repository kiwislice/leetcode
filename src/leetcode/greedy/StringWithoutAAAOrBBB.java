package leetcode.greedy;

/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 */
public class StringWithoutAAAOrBBB {

	public static void main(String[] args) {
		int A = 8, B = 8;
		
		System.out.println(strWithout3a3b(A, B));
	}

	/** 4 ms, faster than 100.00% */
	public static String strWithout3a3b(int A, int B) {
		boolean getA = A>=B;
		int len;
		
		StringBuilder sb = new StringBuilder(A+B);
		while( A+B>0 ) {
			char c = getA?'a':'b';
			len = (getA && A>=B) || (!getA && B>=A)?2:1;
			len = Math.min(len, getA?A:B);
			for(int i=0;i<len;i++)
				sb.append(c);
			
			if( getA )
				A -= len;
			else 
				B -= len;
			getA = !getA;
		}
		return sb.toString();
	}

}
