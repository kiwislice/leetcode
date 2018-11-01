package leetcode.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		Integer[] ar = {1,2,3,4,5};

		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
	}

	// 9 ms
	public int diameterOfBinaryTree(TreeNode root) {
		if( root==null )
			return 0;
		depth(root);
		return max;
	}
	
	int max = 0;
	
	public int depth(TreeNode n) {
		if( n==null )
			return 0;
		
		int L = depth(n.left);
		int R = depth(n.right);
		max = Math.max(max, L+R);
		return 1+Math.max(L, R);
	}
	
	// 22 ms
	public int diameterOfBinaryTreeByRecursive(TreeNode root) {
		if( root==null )
			return 0;
		
		int maxDepth = maxDepth(root.left) + maxDepth(root.right);
		maxDepth = Math.max(maxDepth, diameterOfBinaryTree(root.left));
		maxDepth = Math.max(maxDepth, diameterOfBinaryTree(root.right));
		return maxDepth;
	}

	public static int maxDepth(TreeNode n) {
		if( n==null )
			return 0;
		return 1+Math.max(maxDepth(n.left), maxDepth(n.right));
	}
	
}
