package leetcode.array;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
//		int[] cost = {10, 15, 20};
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

		System.out.println(minCostClimbingStairs(cost));
	}

	// 8 ms
	public static int minCostClimbingStairs(int[] cost) {
		Integer[] result = new Integer[cost.length];
		return sum(cost, 0, result);
	}

	public static int sum(int[] cost, int startInclude, Integer[] result) {
		if( result[startInclude]!=null )
			return result[startInclude];
		
		int len = cost.length-startInclude;
		if( len==1 )
			return 0;
		if( len==2 )
			return Math.min(cost[startInclude], cost[startInclude+1]);
		int a = cost[startInclude]+sum(cost, startInclude+1, result);
		int b = cost[startInclude+1]+sum(cost, startInclude+2, result);
		
		result[startInclude] = Math.min(a, b);
		return result[startInclude];
	}
	
}
