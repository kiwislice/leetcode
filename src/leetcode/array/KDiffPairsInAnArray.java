package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class KDiffPairsInAnArray {

	public static void main(String[] args) {
		// input 2 ans 2
//		int[] ar = { 3, 1, 4, 1, 5 };
		// input 0 ans 1
//		int[] ar = {1,3,1,5,4};
		// input 1 ans 1
//		int[] ar = {1,1,1,2,1};
		// input 2 ans 5
		int[] ar = {6,3,5,7,2,3,3,8,2,4};

		System.out.println(findPairs(ar, 2));
	}

	// 27 ms
	public static int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				// count how many elements in the array that appear more than twice.
				if (entry.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}

		return count;
	}

	// 918 ms
	public static int findPairsByListSet(int[] nums, int k) {
		if (k < 0 || nums == null || nums.length < 2)
			return 0;

		List<Integer> diffList = new LinkedList<>();
		Set<Integer> removeSet = new HashSet<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			while (diffList.remove(Integer.valueOf(nums[i]))) {
				count++;
			}

			if (removeSet.contains(nums[i])) {
				continue;
			} else {
				if (k != 0) {
					if (!removeSet.contains(nums[i] + k))
						diffList.add(nums[i] + k);
					if (!removeSet.contains(nums[i] - k))
						diffList.add(nums[i] - k);
				} else {
					diffList.add(nums[i]);
				}
				removeSet.add(nums[i]);
			}
		}
		return count;
	}

}
