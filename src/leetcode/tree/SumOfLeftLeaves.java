package leetcode.tree;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

	public static void main(String[] args) {
		Integer[] ar = {3,9,20,null,null,15,7};

		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(sumOfLeftLeaves(root));
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if( root==null )
			return 0;
		if( root.left!=null && root.left.left==null && root.left.right==null ) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		
		int sum = 0;
		if( root.left!=null )
			sum += sumOfLeftLeaves(root.left);
		if( root.right!=null )
			sum += sumOfLeftLeaves(root.right);
		return sum;
	}

}
