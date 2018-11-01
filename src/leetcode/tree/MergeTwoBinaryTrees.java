package leetcode.tree;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if( t1==null && t2!=null )
			t1 = new TreeNode(0);
		
		dfs(t1, t2);
		return t1;
	}
	
	public static void dfs(TreeNode t1, TreeNode t2) {
		if( t1==null || t2==null )
			return ;
		
		t1.val += t2.val;
		if( t2.left!=null ) {
			if( t1.left==null )
				t1.left = new TreeNode(0);
			dfs(t1.left, t2.left);
		}
		if( t2.right!=null ) {
			if( t1.right==null )
				t1.right = new TreeNode(0);
			dfs(t1.right, t2.right);
		}
	}

}
