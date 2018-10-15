package leetcode.math;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		boolean suc = containsPoint(rec1, new int[] {rec2[0], rec2[1]});
		suc |= containsPoint(rec1, new int[] {rec2[0], rec2[3]});
		suc |= containsPoint(rec1, new int[] {rec2[2], rec2[1]});
		suc |= containsPoint(rec1, new int[] {rec2[2], rec2[3]});
		
		suc |= containsPoint(rec2, new int[] {rec1[0], rec1[1]});
		suc |= containsPoint(rec2, new int[] {rec1[0], rec1[3]});
		suc |= containsPoint(rec2, new int[] {rec1[2], rec1[1]});
		suc |= containsPoint(rec2, new int[] {rec1[2], rec1[3]});
		
		
		
	}

	public static boolean containsPoint(int[] rec, int[] p) {
		boolean suc = rec[0] <= p[0] && p[0] <= rec[2];
		suc &= rec[1] <= p[1] && p[1] <= rec[3];
		return suc;
	}

	public static boolean containsPath(int[] rec1, int[] rec2) {
		boolean suc = rec1[0] <= rec2[0] && rec2[0] <= rec1[2];
		
		
		suc &= rec[1] <= p[1] && p[1] <= rec[3];
		return suc;
	}

}
