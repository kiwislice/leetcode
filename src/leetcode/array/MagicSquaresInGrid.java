package leetcode.array;

/**
 * https://leetcode.com/problems/magic-squares-in-grid/
 */
public class MagicSquaresInGrid {

	public static void main(String[] args) {
		// 0
//		int[][] grid = {{1,8,6},{10,5,0},{4,2,9}};
		// 1
		int[][] grid = {{3,10,2,3,4},{4,5,6,8,1},{8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}};
		
		System.out.println(numMagicSquaresInside(grid));
	}

	public static int numMagicSquaresInside(int[][] grid) {
		if( grid==null || grid.length<3 || grid[0].length<3 )
			return 0;
		
		final int nrow = grid.length;
		final int ncol = grid[0].length;
		
		int count = 0;
		for(int r=0;r<nrow-2;r++) {
			for(int c=0;c<ncol-2;c++) {
				if( isMagicSquare(grid, r, c) )
					count++;
			}
		}
		return count;
	}
	
	public static boolean isMagicSquare(int[][] grid, int row, int col) {
		if( grid[row+1][col+1]!=5 )
			return false;
		
		int xor = 1^2^3^4^5^6^7^8^9;
		for(int r=row;r<row+3;r++) {
			for(int c=col;c<col+3;c++) {
				xor ^= grid[r][c];
			}
		}
		if( xor!=0 )
			return false;
		
		int sum1 = 0;
		int sum2 = 0;
		for(int r=row;r<row+3;r++) {
			sum1 += grid[r][col];
			sum2 += grid[r][col+2];
		}
		if( sum1!=15 || sum2!=15 )
			return false;
		
		sum1 = 0;
		sum2 = 0;
		for(int c=col;c<col+3;c++) {
			sum1 += grid[row][c];
			sum2 += grid[row+2][c];
		}
		return sum1==15 && sum2==15;
	}
	
}
