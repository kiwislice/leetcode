package leetcode.array;

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] transpose(int[][] A) {
		final int nrow = A.length;
		final int ncol = A[0].length;
		
		int[][] rtn = new int[ncol][nrow];
		
		for(int r=0;r<ncol;r++) {
			for(int c=0;c<nrow;c++) {
				rtn[r][c] = A[c][r];
			}
		}
		return rtn;
	}

}
