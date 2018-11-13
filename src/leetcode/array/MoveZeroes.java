package leetcode.array;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1 ms
	public void moveZeroes(int[] nums) {
		if( nums==null || nums.length<2 )
			return ;
		
		int zIndex = 0;
		for(int i=0;i<nums.length;i++) {
			if( nums[i]!=0 ) {
				int d = nums[zIndex];
				nums[zIndex++] = nums[i];
				nums[i] = d;
			}
		}
	}

	// 2 ms
	public void moveZeroesOld(int[] nums) {
		if( nums==null || nums.length<2 )
			return ;
		
		int zIndex = -1;
		for(int i=0;i<nums.length;i++) {
			if( nums[i]==0 ) {
				if( zIndex==-1 )
					zIndex = i;
			}
			else if( zIndex!=-1 ) {
				nums[zIndex] = nums[i];
				nums[i] = 0;
				zIndex++;
			}
		}
	}

}
