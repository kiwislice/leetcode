package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

	public static void main(String[] args) {
		System.out.println(getRow(4));

	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> rtn = new ArrayList<>(rowIndex+1);
		rtn.add(1);
		for(int i=0;i<rowIndex;i++) {
			for(int j=i;j>=1;j--) {
				rtn.set(j, rtn.get(j)+rtn.get(j-1));
			}
			rtn.add(1);
		}
		return rtn;
	}

}
