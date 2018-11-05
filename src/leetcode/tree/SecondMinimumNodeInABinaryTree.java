package leetcode.tree;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinimumNodeInABinaryTree {

	public static void main(String[] args) {
//		Integer[] ar = {2,2,5,null,null,5,7};
		Integer[] ar = {5,8,5};
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(new SecondMinimumNodeInABinaryTree().findSecondMinimumValue(root));
	}

	// 3 ms
	public int findSecondMinimumValue(TreeNode root) {
		if( root==null || root.left==null )
			return -1;
		int L = root.left.val==root.val?findSecondMinimumValue(root.left):root.left.val;
		int R = root.right.val==root.val?findSecondMinimumValue(root.right):root.right.val;
		return L==-1||R==-1?Math.max(L, R):Math.min(L, R);
	}
	
	// 原 3 ms
	public int findSecondMinimumValueByHelper(TreeNode root) {
		if( root==null )
			return -1;
		int h = helper(root, root.val);
		return h==root.val?-1:h;
	}

	public static int helper(TreeNode t, int rv) {
		if( t.val!=rv )
			return t.val;
		if( t.left==null )
			return rv;
		
		int L = helper(t.left, rv);
		int R = helper(t.right, rv);
		
		if( L==rv )
			return R;
		if( R==rv )
			return L;
		return Math.min(L, R);
	}
	
}
