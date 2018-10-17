package leetcode.math;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionAreaOf3dShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int projectionArea(int[][] grid) {
		int sum = 0;
		
		for(int[] row:grid) {
			int rowMax = 0;
			for(int i=0;i<row.length;i++) {
				if( row[i]!=0 )
					sum++;
				rowMax = Math.max(rowMax, row[i]);
			}
			sum += rowMax;
		}
		
		for(int i=0;i<50;i++) {
			int maxCol = 0;
			for(int r=0;r<grid.length;r++) {
				if( i<grid[r].length ) {
					maxCol = Math.max(maxCol, grid[r][i]);
				}
			}
			sum += maxCol;
		}
		
		return sum;
	}

}
