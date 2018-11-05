package leetcode.tree;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 4 ms
	public TreeNode searchBST(TreeNode root, int val) {
		if( root==null )
			return null;
		if( val==root.val )
			return root;
		if( val>root.val )
			return searchBST(root.right, val);
		return searchBST(root.left, val);
	}

	// 4 ms
	public TreeNode searchBSTByWhile(TreeNode root, int val) {
		if( root==null )
			return null;
		
		TreeNode cur = root;
		while(cur!=null) {
			if( val==cur.val )
				return cur;
			cur = val>cur.val?cur.right:cur.left;
		}
		return null;
	}

}
