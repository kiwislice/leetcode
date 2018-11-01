package leetcode.tree;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {

	public static void main(String[] args) {
		// input 8 ans 3
//		Integer[] ar = {10,5,-3,3,2,null,11,3,-2,null,1};
		// input 1 ans 1
		Integer[] ar = {1};
				
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(pathSum(root, 1));
	}

	public static int pathSum(TreeNode root, int sum) {
		if( root==null )
			return 0;
		return pathSumHelper(root, sum, false);
	}

	public static int pathSumHelper(TreeNode root, int sum, boolean onPath) {
		int count = 0;
		if( root.val==sum ) {
			count += 1;
		}
		if( root.left!=null ) {
			if( !onPath )
				count += pathSumHelper(root.left, sum, false);
			count += pathSumHelper(root.left, sum-root.val, true);
		}
		if( root.right!=null ) {
			if( !onPath )
				count += pathSumHelper(root.right, sum, false);
			count += pathSumHelper(root.right, sum-root.val, true);
		}
		return count;
	}

}
