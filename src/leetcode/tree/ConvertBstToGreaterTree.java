package leetcode.tree;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBstToGreaterTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode convertBST(TreeNode root) {
		if( root==null )
			return root;
		
		inorder(root);
		return root;
	}

	int sum = 0;
	
	public void inorder(TreeNode n) {
		if( n.right!=null )
			inorder(n.right);
		
		sum += n.val;
		n.val = sum;
		
		if( n.left!=null )
			inorder(n.left);
	}
	
}
