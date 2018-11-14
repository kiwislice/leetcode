package leetcode.array;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlippingAnImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] flipAndInvertImage(int[][] A) {
		final int nrow = A.length;
		final int ncol = A[0].length;
		int[][] rtn = new int[nrow][ncol];
		
		for(int r=0;r<nrow;r++) {
			for(int c=0;c<ncol;c++) {
				rtn[r][c] = A[r][ncol-1-c] ^ 1;
			}
		}
		
		return rtn;
	}

}
