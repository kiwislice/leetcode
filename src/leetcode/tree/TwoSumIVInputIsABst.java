package leetcode.tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIVInputIsABst {

	public static void main(String[] args) {
		// input 9 ans true
		Integer[] ar = {5,3,6,2,4,null,7};
		// input 4 ans true
//		Integer[] ar = {2,1,3};
		// input -1 ans true
//		Integer[] ar = {2,0,3,-4,1};
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(findTarget(root, 9));

	}

	// 22 ms 
	public static boolean findTarget(TreeNode root, int k) {
        if( root==null )
        	return false;
        return dfs(root, root, k);
    }

	public static boolean dfs(TreeNode cur, TreeNode root, int k) {
		if( cur==null )
        	return false;
		if( binSearch(cur, root, k-cur.val) )
        	return true;
		return dfs(cur.left, root, k) || dfs(cur.right, root, k);
	}
	
	public static boolean binSearch(TreeNode cur, TreeNode n, int target) {
		if( n==null )
			return false;
		if( n!=cur && n.val==target )
			return true;
		return target>n.val?
				binSearch(cur, n.right, target):
					binSearch(cur, n.left, target);
	}
	
	// 26 ms
	public static boolean findTargetBySet(TreeNode root, int k) {
        if( root==null )
        	return false;
        TreeSet<Integer> set = new TreeSet<>();
        return inorder(root, k, set);
    }

	public static boolean inorder(TreeNode root, int k, Set<Integer> set) {
        if( root==null )
        	return false;
        
        boolean found = false;
        if( root.left!=null )
        	found = found || inorder(root.left, k, set);
        
        if( set.contains(root.val) )
        	return true;
        set.add(k-root.val);
        
        if( root.right!=null )
        	found = found || inorder(root.right, k, set);
        
        return found;
    }

}
