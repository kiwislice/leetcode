package leetcode.tree;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isUnivalTree(TreeNode root) {
		return dfs(root.left, root.val) && dfs(root.right, root.val);
	}
	
	public static boolean dfs(TreeNode root, int n) {
		if( root==null )
			return true;
		if( root.val!=n )
			return false;
		
		return dfs(root.left, n) && dfs(root.right, n);
	}
	
}
