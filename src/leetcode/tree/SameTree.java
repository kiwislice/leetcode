package leetcode.tree;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if( p==null ^ q==null )
			return false;
		if( p==null && q==null )
			return true;
		
		boolean same = p.val==q.val;
		same &= isSameTree(p.left, q.left);
		same &= isSameTree(p.right, q.right);
		return same;
	}

}
