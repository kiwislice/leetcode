package leetcode.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AA"));
		System.out.println(titleToNumber("AZ"));
		System.out.println(titleToNumber("BA"));
		System.out.println(titleToNumber("ZZ"));
		System.out.println(titleToNumber("AAA"));
		System.out.println(titleToNumber("ABA"));
	}

	public static int titleToNumber(String s) {
		int sum = 0;
		int count = 1;
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			sum += (c-'@')*count;
			count *= 26;
		}
		return sum;
	}

}
