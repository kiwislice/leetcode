package leetcode.array;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeTheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int count = nums.length * nums[0].length;
		if( count!=r*c )
			return nums;
		
		int[][] rtn = new int[r][c];
		int index = 0;
		for(int[] row:nums) {
			for(int nij:row) {
				rtn[index/c][index%c] = nij;
				index++;
			}
		}
		return rtn;
	}

}
