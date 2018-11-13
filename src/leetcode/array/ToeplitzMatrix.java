package leetcode.array;

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] m = {{65,98,57}};
//		int[][] m = {{1,2},{2,2}};
//		int[][] m = {{11,74,0,93},{40,11,74,7}};
		
		System.out.println(isToeplitzMatrix(m));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if( matrix==null || matrix.length<=1 || matrix[0].length<=1 )
			return true;
		
		final int nrow = matrix.length;
		final int ncol = matrix[0].length;
		
		for(int r=1;r<nrow;r++) {
			for(int c=1;c<ncol;c++) {
				if( matrix[r][c]!=matrix[r-1][c-1] )
					return false;
			}
		}
		return true;
	}

}
