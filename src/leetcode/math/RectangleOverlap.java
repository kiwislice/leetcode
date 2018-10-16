package leetcode.math;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {

	public static void main(String[] args) {
		// false
		int[] rec1 = {0,0,1,1};
		int[] rec2 = {1,0,2,1};
		System.out.println(isRectangleOverlap(rec1, rec2));

	}

	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return containsX(rec1, rec2) && containsY(rec1, rec2);
	}

	public static boolean containsX(int[] rec1, int[] rec2) {
		boolean suc = rec1[0] < rec2[0] && rec2[0] < rec1[2];
		suc |= rec1[0] < rec2[2] && rec2[2] < rec1[2];
		
		suc |= rec2[0] < rec1[0] && rec1[0] < rec2[2];
		suc |= rec2[0] < rec1[2] && rec1[2] < rec2[2];
		return suc;
	}

	public static boolean containsY(int[] rec1, int[] rec2) {
		boolean suc = rec1[1] < rec2[1] && rec2[1] < rec1[3];
		suc |= rec1[1] < rec2[3] && rec2[3] < rec1[3];
		
		suc |= rec2[1] < rec1[1] && rec1[1] < rec2[3];
		suc |= rec2[1] < rec1[3] && rec1[3] < rec2[3];
		return suc;
	}

}
