package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {

	public static void main(String[] args) {
		String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] list2 = {"KFC","Shogun","Burger King"};

		System.out.println(Arrays.toString(findRestaurant(list1, list2)));
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		if( list1.length>list2.length )
			return findRestaurant(list2, list1);
		
		Map<String, Integer> m = new HashMap<>(list1.length);
		for(int i=0;i<list1.length;i++)
			m.put(list1[i], i);
		
		List<String> rtn = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<list2.length;i++) {
			Integer i1 = m.remove(list2[i]);
			if( i1==null || i1+i>min ) continue;
			
			if( i1+i<min ) {
				rtn.clear();
				min = i1+i;
			}
			rtn.add(list2[i]);
		}
		return rtn.toArray(new String[] {});
	}

}
