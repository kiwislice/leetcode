package leetcode.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/ 
 * 1 -> A; 2 -> B; 3 ->C
 */
public class ExcelSheetColumnTitle {
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(53));
		System.out.println(convertToTitle(26+26*26));
		System.out.println(convertToTitle(26+26*26+1));
		System.out.println(convertToTitle(26+26*26+27));
	}

	static final char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public static String convertToTitle(int n) {
		if( n<=0 )
			return "";
		
		StringBuilder sb = new StringBuilder();
		n -= 1;
		sb.insert(0, alpha[n%26]);

		while( n>=26 ) {
			n -= 26;
			n /= 26;
			sb.insert(0, alpha[n%26]);
		}
		
		return sb.toString();
	}
	
}
