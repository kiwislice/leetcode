package leetcode.tree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		Integer[] sar = {3,4,5,1,2,null,null,0};
		Integer[] tar = {4,1,2};
				
		TreeNode s = TreeNode.asTreeNode(sar);
		TreeNode t = TreeNode.asTreeNode(tar);
		System.out.println(isSubtree(s, t));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if( s==null )
			return false;
		if( t==null )
			return true;
		return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public static boolean sameTree(TreeNode a, TreeNode b) {
		if( a==null && b==null )
			return true;
		if( a==null || b==null || a.val!=b.val )
			return false;
		return sameTree(a.left, b.left) && sameTree(a.right, b.right);
	}
	
}
