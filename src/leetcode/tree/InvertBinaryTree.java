package leetcode.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if( root==null )
			return null;
		
		TreeNode n = root.right;
		root.right = root.left;
		root.left = n;
		
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
