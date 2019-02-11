package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class MinimumASCIIDeleteSumForTwoStrings {

	public static void main(String[] args) {
		// 403
		String s1 = "delete", s2 = "leet";
		// 231
//		String s1 = "sea", s2 = "eat";
		// 116
//		String s1 = "a", s2 = "at";

		System.out.println(minimumDeleteSum(s1, s2));
	}

	/**
	 * 21 ms, faster than 76.28%
	 * 24.6 MB, less than 88.52%
	 * 參考https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108811/JavaDP(With-Explanation)
	 */
	public static int minimumDeleteSum(String s1, String s2) {
		final int len1 = s1.length();
		final int len2 = s2.length();
		
		// 存放minimumDeleteSum(s1[0:i],s2[0:j])，#s1[0:0]視為空字串
		int[][] dp = new int[len1+1][len2+1];
		
		// 一邊為空字串時，dp=另一邊字元加總
		for(int i=1;i<=len1;i++) {
			dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
		}
		for(int j=1;j<=len2;j++) {
			dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
		}

		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				// 尾部字元相同時，dp[i][j] = dp[i-1][j-1]
				if( s1.charAt(i-1)==s2.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1];
				}
				// 尾部字元不同時
				else {
					dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
				}
			}
		}
		return dp[len1][len2];
	}

}
