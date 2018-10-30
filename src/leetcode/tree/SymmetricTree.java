package leetcode.tree;

public class SymmetricTree {

	public static void main(String[] args) {
//		Integer[] ar = new Integer[] {1,2,3,3,null,2,null};
//		Integer[] ar = new Integer[] {1,2};
		Integer[] ar = new Integer[] {1,2,2,3,4,4,3};
		
		TreeNode root = TreeNode.asTreeNode(ar);
		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(TreeNode root) {
		if( root==null )
			return true;
		
		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode t1, TreeNode t2) {
		boolean same = t1==t2;
		same |= t1!=null && t2!=null && t1.val==t2.val;
		if( !same )
			return false;
		if( t1==null )
			return true;
		
		return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
	}
	
}
