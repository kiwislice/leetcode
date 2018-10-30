package leetcode.tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
		return minDepth(root, 0);
	}

	public static int minDepth(TreeNode root, int depth) {
		if( root==null )
			return 0;
		if( root.left==null && root.right==null )
			return 1+depth;
		
		int min = Integer.MAX_VALUE;
		if( root.left!=null )
			min = Math.min(min, minDepth(root.left, depth+1));
		if( root.right!=null )
			min = Math.min(min, minDepth(root.right, depth+1));
		return min;
	}
	
}
