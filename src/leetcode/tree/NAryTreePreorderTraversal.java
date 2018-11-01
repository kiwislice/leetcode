package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorder(Node root) {
		List<Integer> list = new LinkedList<>();
		preorderDfs(root, list);
		return list;
	}
	
	public static void preorderDfs(Node root, List<Integer> list) {
		if( root==null )
			return ;
		
		list.add(root.val);
		if( root.children!=null && !root.children.isEmpty() ) {
			for(Node c:root.children)
				preorderDfs(c, list);
		}
	}

}
