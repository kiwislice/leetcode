package leetcode.math;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class SurfaceAreaOf3dShapes {

	public static void main(String[] args) {
		// 32
		int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println(surfaceArea(grid));

	}

	public static int surfaceArea(int[][] grid) {
		int sum = 0;
		
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid[r].length;c++) {
				int z = grid[r][c];
				if( z!=0 )
					sum += 2;
				
				sum += r-1<0?z:grid[r-1][c]>=z?0:z-grid[r-1][c];
				sum += r+1>=grid.length?z:grid[r+1][c]>=z?0:z-grid[r+1][c];
				sum += c-1<0?z:grid[r][c-1]>=z?0:z-grid[r][c-1];
				sum += c+1>=grid.length?z:grid[r][c+1]>=z?0:z-grid[r][c+1];
			}
		}
		
		return sum;
	}

	public static int surfaceAreaByObj(int[][] grid) {
		int sum = 0;
		boolean[][][] obj = new boolean[grid.length][50][50];
		
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid[r].length;c++) {
				if( grid[r][c]!=0 )
					sum++;
				for(int z=0;z<grid[r][c];z++) {
					obj[r][c][z] = true;
				}
			}
		}
		
		sum <<= 1;
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid[r].length;c++) {
				for(int z=0;z<grid[r][c];z++) {
					if( !obj[r][c][z] )
						continue;
					
					sum += r-1<0||!obj[r-1][c][z]?1:0;
					sum += r+1>grid.length-1||!obj[r+1][c][z]?1:0;
					sum += c-1<0||!obj[r][c-1][z]?1:0;
					sum += c+1>grid[r].length-1||!obj[r][c+1][z]?1:0;
				}
			}
		}
		
		return sum;
	}

}
