package leetcode.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {
		if( root==null )
			return Collections.emptyList();
		
		List<String> rtn = new LinkedList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		dfs(root, queue, rtn);
		return rtn;
    }

	public static void dfs(TreeNode n, Deque<TreeNode> queue, List<String> rtn) {
		queue.addLast(n);
		
		if( n.left!=null )
			dfs(n.left, queue, rtn);
		if( n.right!=null )
			dfs(n.right, queue, rtn);
		
		if( n.left==null && n.right==null ) {
			// 14 ms
			StringBuilder sb = new StringBuilder();
			for(TreeNode t:queue) {
				sb.append(t.val+"->");
			}
			sb.delete(sb.length()-2, sb.length());
			
			// 61 ms
//			String s = queue.stream().map(p -> String.valueOf(p.val)).collect(Collectors.joining("->"));
			rtn.add(sb.toString());
		}
		queue.removeLast();
	}
	
}
