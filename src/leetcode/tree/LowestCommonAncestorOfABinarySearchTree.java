package leetcode.tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfABinarySearchTree {

	public static void main(String[] args) {
		// 3
		Integer[] ar = {6,2,8,0,4,7,9,null,null,3,5};
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5)));
	}

	// 5ms 減少判斷後
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if( p.val>q.val )
			return lowestCommonAncestor(root, q, p);
		
		TreeNode cur = root;
		while(true) {
			boolean sameSide = cur.val < p.val || cur.val > q.val;
			
			if( !sameSide )
				return cur;
			
			cur = cur.val<p.val?cur.right:cur.left;
		}
	}
	
	// 8ms
	public TreeNode lowestCommonAncestorByReRecursive(TreeNode root, TreeNode p, TreeNode q) {
        boolean sameSide = (root.val < p.val && root.val < q.val)
				|| (root.val > p.val && root.val > q.val);
		
		if( !sameSide )
			return root;
		
		if( root.val < p.val )
			return lowestCommonAncestor(root.right, p, q);
		return lowestCommonAncestor(root.left, p, q);
    }
	
}
