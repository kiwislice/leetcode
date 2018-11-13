package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rtn = new LinkedList<>();
		if( numRows<1 )
			return rtn;
		rtn.add(Arrays.asList(1));
		if( numRows==1 )
			return rtn;
		
		List<Integer> last = rtn.get(0);
		for(int i=1;i<numRows;i++) {
			List<Integer> next = next(last);
			rtn.add(next);
			last = next;
		}
		return rtn;
	}

	public static List<Integer> next(List<Integer> row){
		List<Integer> rtn = new LinkedList<>(row);
		final int len = row.size();
		for(int i=0;i<len-1;i++) {
			rtn.set(i+1, rtn.get(i+1)+row.get(i));
		}
		rtn.add(1);
		return rtn;
	}
	
}
