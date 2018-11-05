package leetcode.tree;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {

	public static void main(String[] args) {
		// 2
		Integer[] ar = {5,4,5,1,1,5};
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
	}

	// 8 ms 神奇遞迴(1次DFS)
	public int longestUnivaluePath(TreeNode root) {
		if( root==null )
			return 0;
		helper(root, root.val);
		return result;
	}
	
	int result = 0;
	
	public int helper(TreeNode t, int v) {
		if( t==null ) return 0;
		int L = helper(t.left, t.val);
		int R = helper(t.right, t.val);
		result = Math.max(result, L+R);
		return t.val!=v?0:1+Math.max(L, R);
	}
	

	// 28 ms
	public int longestUnivaluePathBy多次dfs(TreeNode root) {
		if( root==null )
			return 0;
		
		int L = root.left==null?0:maxDepth(root.left, root.val);
		int R = root.right==null?0:maxDepth(root.right, root.val);
		max = Math.max(max, L+R);
		
		longestUnivaluePath(root.left);
		longestUnivaluePath(root.right);
		return max;
	}

	int max = 0;
	
	public static int maxDepth(TreeNode t, int v) {
		if( t.val!=v ) return 0;
		int L = t.left==null||t.left.val!=v?0:maxDepth(t.left, v);
		int R = t.right==null||t.right.val!=v?0:maxDepth(t.right, v);
		return Math.max(L, R)+1;
	}
	
}
