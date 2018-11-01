package leetcode.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNAryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(Node root) {
		if( root==null )
			return 0;
		if( root.children==null || root.children.isEmpty() )
			return 1;
		
		int maxDepth = 0;
		for(Node c:root.children) {
			maxDepth = Math.max(maxDepth, maxDepth(c));
		}
		return maxDepth+1;
	}

}
