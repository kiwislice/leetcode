package leetcode.tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// true
		Integer[] ar = {3,9,20,null,null,15,7};
		// false
//		Integer[] ar = {1,null,2,null,3};
		// true
//		Integer[] ar = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
		// false
//		Integer[] ar = {1,2,2,3,3,null,null,4,4};
		
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		if( root==null )
			return true;
		
		int diff = maxDepth(root.left)-maxDepth(root.right);
		if( Math.abs(diff)>1 )
			return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int maxDepth(TreeNode root) {
		if( root==null )
			return 0;
		
		int max = 1;
		if( root.left!=null )
			max = Math.max(max, 1+maxDepth(root.left));
		if( root.right!=null )
			max = Math.max(max, 1+maxDepth(root.right));
		return max;
	}
	
}
