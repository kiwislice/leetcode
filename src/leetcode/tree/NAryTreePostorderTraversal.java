package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorder(Node root) {
		List<Integer> list = new LinkedList<>();
		postorderDfs(root, list);
		return list;
	}
	
	public static void postorderDfs(Node root, List<Integer> list) {
		if( root==null )
			return ;
		
		if( root.children!=null && !root.children.isEmpty() ) {
			for(Node c:root.children)
				postorderDfs(c, list);
		}
		list.add(root.val);
	}

}
