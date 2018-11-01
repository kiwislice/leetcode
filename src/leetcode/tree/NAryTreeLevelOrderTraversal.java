package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> rtn = new LinkedList<>();
		
		if( root==null )
			return rtn;
		
		dfs(root, 0, rtn);
		return rtn;
	}

	public static void dfs(Node root, int depth, List<List<Integer>> rtn) {
		if( rtn.size()<=depth ) {
			rtn.add(new LinkedList<>());
		}
		rtn.get(depth).add(root.val);
		if( root.children!=null ) {
			for(Node c:root.children) {
				dfs(c, depth+1, rtn);
			}
		}
	}
	
}
