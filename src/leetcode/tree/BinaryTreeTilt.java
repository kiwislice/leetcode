package leetcode.tree;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

	public static void main(String[] args) {
		// 40
		Integer[] ar = {1,2,null,3,null,4,null,5};

		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(new BinaryTreeTilt().findTilt(root));
	}

	// 7 ms
	public int findTilt(TreeNode root) {
		if( root==null )
			return 0;
		dfs(root);
		return res;
	}

	int res = 0;
	
	public int dfs(TreeNode root) {
		if( root==null )
			return 0;
		
		int leftSum = dfs(root.left);
		int rightSum = dfs(root.right);
		res += Math.abs(leftSum-rightSum);
		return root.val+leftSum+rightSum;
	}

	// 16 ms
	public int findTiltBy多次dfs(TreeNode root) {
		if( root==null )
			return 0;
		
		sumNodeTilt(root);
		
		return sumNodeTilt;
	}

	int sumNodeTilt = 0;
	
	public void sumNodeTilt(TreeNode root) {
		if( root==null )
			return ;
		
		if(root.left!=null)
			sumNodeTilt(root.left);
		if(root.right!=null)
			sumNodeTilt(root.right);
		
		sumNodeTilt += Math.abs(sum(root.left)-sum(root.right));
	}

	public static int sum(TreeNode root) {
		if( root==null )
			return 0;
		
		int sum = root.val;
		if( root.left!=null )
			sum += sum(root.left);
		if( root.right!=null )
			sum += sum(root.right);
		return sum;
	}
	
}
