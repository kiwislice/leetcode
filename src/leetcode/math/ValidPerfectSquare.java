package leetcode.math;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(808201));

	}

	public static boolean isPerfectSquare(int num) {
		if (num < 0)
			return false;
		if (num < 2)
			return true;

		int min = 1;
		int max = num;

		while (max - min > 1) {
			int mid = (max + min) / 2;
			if (mid * mid == num)
				return true;
			else if (mid < num / mid)
				min = mid;
			else
				max = mid;
		}
		return false;
	}

	public boolean isPerfectSquareByFormula(int num) {
		// A square number is 1+3+5+7+...
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}

}
