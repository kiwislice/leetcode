package leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if( root==null )
			return Collections.emptyList();
			
		final List<List<Integer>> rtn = new LinkedList<>();
		dfs(root, 0, rtn);
		Collections.reverse(rtn);
		return rtn;
	}

	public static void dfs(TreeNode node, int depth, List<List<Integer>> rtn) {
		if( rtn.size()<=depth ) {
			for(int i=rtn.size();i<=depth;i++)
				rtn.add(new LinkedList<>());
		}
		
		if( node.left!=null )
			dfs(node.left, depth+1, rtn);
		if( node.right!=null )
			dfs(node.right, depth+1, rtn);
		rtn.get(depth).add(node.val);
	}
	
}
