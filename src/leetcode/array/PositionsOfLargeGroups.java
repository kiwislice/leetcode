package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class PositionsOfLargeGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> rtn = new LinkedList<>();
		
		char curC = S.charAt(0);
		int count = 1;
		for(int i=1;i<S.length();i++) {
			if( S.charAt(i)==curC ) {
				count++;
			}
			else {
				if( count>=3 ) {
					rtn.add(Arrays.asList(i-count, i-1));
				}
				curC = S.charAt(i);
				count = 1;
			}
		}
		
		if( count>=3 ) {
			rtn.add(Arrays.asList(S.length()-count, S.length()-1));
		}
		
		return rtn;
	}

}
