package leetcode.math;

/**
 * https://leetcode.com/problems/reach-a-number/
 */
public class ReachANumber {

	public static void main(String[] args) {
		System.out.println(reachNumber(2)); // 3
		System.out.println(reachNumber(3)); // 2
		System.out.println(reachNumber(4)); // 3
		System.out.println(reachNumber(5)); // 5
		System.out.println(reachNumber(7)); // 5
	}

	public static int reachNumber(int target) {
		target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
	}

}
