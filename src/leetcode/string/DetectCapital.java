package leetcode.string;

/**
 * https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {

	public static void main(String[] args) {
		String word = "USA";
//		String word = "FlaG";
//		String word = "leetcode";
//		String word = "Leetcode";

		System.out.println(detectCapitalUse(word));
	}

	// 20 ms
	public static boolean detectCapitalUse(String word) {
		int sum = 0;
		for(int i=0;i<word.length();i++) {
			sum += Character.isUpperCase(word.charAt(i))?-1:1;
		}
		boolean suc = sum==word.length()-2 && Character.isUpperCase(word.charAt(0));
		suc = suc || Math.abs(sum)==word.length();
		return suc;
	}

	// 20 ms
	public static boolean detectCapitalUseOld(String word) {
		int sum = 0;
		for(int i=0;i<word.length();i++) {
			sum += Math.signum(word.charAt(i)-'a'+1);
		}
		boolean suc = sum==word.length()-2 && Character.isUpperCase(word.charAt(0));
		suc = suc || Math.abs(sum)==word.length();
		return suc;
	}

}
