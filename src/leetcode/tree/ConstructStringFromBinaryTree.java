package leetcode.tree;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

	public static void main(String[] args) {
		Integer[] ar = {1,2,3,4};

		TreeNode t = TreeNode.asTreeNode(ar);
		System.out.println(tree2str(t));
	}

	public static String tree2str(TreeNode t) {
		if( t==null )
			return "";
		if( t.left==null && t.right==null )
			return String.valueOf(t.val);
		StringBuilder sb = new StringBuilder();
		helper(t, sb);
		return sb.toString();
	}

	// 8ms
	public static void helper(TreeNode t, StringBuilder sb) {
		if( t==null )
			return ;
		
		sb.append(t.val);
		if( t.left==null && t.right==null )
			return ;
		
		sb.append("(");
		helper(t.left, sb);
		sb.append(")");
		
		if( t.right!=null ) {
			sb.append("(");
			helper(t.right, sb);
			sb.append(")");
		}
	}

	// 19 ms
	public static void helper2(TreeNode t, StringBuilder sb) {
		if( t==null )
			return ;
		else if( t.left==null && t.right==null )
			sb.append(t.val);
		else if( t.right!=null ) {
			sb.append(t.val+"(");
			helper(t.left, sb);
			sb.append(")(");
			helper(t.right, sb);
			sb.append(")");
		}
		else {
			sb.append(t.val+"(");
			helper(t.left, sb);
			sb.append(")");
		}
	}

	// 28 ms
	public static String tree2strByString(TreeNode t) {
		if( t==null )
			return "";
		if( t.left==null && t.right==null )
			return String.valueOf(t.val);
		if( t.right!=null )
			return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
		return t.val+"("+tree2str(t.left)+")";
	}

}
