package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Queue<Integer> queue = new LinkedList<>();
		in(root1, queue);
		return root2==null?queue.isEmpty():out(root2, queue);
	}

	public static void in(TreeNode t, Queue<Integer> queue) {
		if( t==null )
			return ;
		if( t.left==null && t.right==null ) {
			queue.add(t.val);
			return ;
		}
		if( t.left!=null )
			in(t.left, queue);
		if( t.right!=null )
			in(t.right, queue);
	}

	public static boolean out(TreeNode t, Queue<Integer> queue) {
		if( t.left==null && t.right==null ) {
			return t.val==queue.remove();
		}
		boolean b = true;
		if( t.left!=null )
			b = b && out(t.left, queue);
		if( t.right!=null )
			b = b && out(t.right, queue);
		return b;
	}
	
}
