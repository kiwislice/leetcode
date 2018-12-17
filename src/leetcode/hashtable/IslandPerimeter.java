package leetcode.hashtable;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		// 16
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		// 4
//		int[][] grid = {{1}};

		System.out.println(islandPerimeter(grid));
	}

//	如果當前點是一個島，則計算它是否有任何右鄰居或鄰居;
//	結果是島嶼* 4 - 鄰居* 2
	
	// 83 ms, faster than 40.24%
	public static int islandPerimeter(int[][] grid) {
		final int nrow = grid.length;
		final int ncol = grid[0].length;
		int island = 0, neighbour = 0;
		
		for(int i=0;i<nrow;i++) {
			for(int j=0;j<ncol;j++) {
				if( grid[i][j]==1 ) {
					island++;
					
					if( i<nrow-1 && grid[i+1][j]==1 ) neighbour++;
					if( j<ncol-1 && grid[i][j+1]==1 ) neighbour++;
				}
			}
		}
		return island*4-neighbour*2;
	}

	// 88 ms, faster than 33.92% 
	public static int islandPerimeterOld(int[][] grid) {
		final int nrow = grid.length;
		final int ncol = grid[0].length;
		int count = 0;
		for(int i=0;i<nrow;i++) {
			for(int j=0;j<ncol;j++) {
				if( grid[i][j]==0 ) {
					if( i>0 && grid[i-1][j]==1 ) count++;
					if( i<nrow-1 && grid[i+1][j]==1 ) count++;
					if( j>0 && grid[i][j-1]==1 ) count++;
					if( j<ncol-1 && grid[i][j+1]==1 ) count++;
				}
				else if( i==0 || i==nrow-1 || j==0 || j==ncol-1 ) {
					if( i==0 ) count++;
					if( i==nrow-1 ) count++;
					if( j==0 ) count++;
					if( j==ncol-1 ) count++;
				}
			}
		}
		return count;
	}

}
