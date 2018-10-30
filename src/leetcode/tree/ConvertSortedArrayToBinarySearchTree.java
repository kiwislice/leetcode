package leetcode.tree;

public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,7,8};
		System.out.println(sortedArrayToBST(nums));
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length-1);
	}

	public static TreeNode sortedArrayToBST簡化版(int[] nums, int s, int e) {
		if( s>e ) return null;
		int mid = (e+s+1)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, s, mid-1);
		root.right = sortedArrayToBST(nums, mid+1, e);
		return root;
	}
	
	public static TreeNode sortedArrayToBST(int[] nums, int s, int e) {
		int len = e-s+1;
		if( len>3 ) {
			int mid = (e+s+1)/2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = sortedArrayToBST(nums, s, mid-1);
			root.right = sortedArrayToBST(nums, mid+1, e);
			return root;
		}
		if( len==3 ) {
			TreeNode root = new TreeNode(nums[s+1]);
			root.left = new TreeNode(nums[s]);
			root.right = new TreeNode(nums[e]);
			return root;
		}
		if( len==2 ) {
			TreeNode root = new TreeNode(nums[e]);
			root.left = new TreeNode(nums[s]);
			return root;
		}
		if( len==1 ) {
			return new TreeNode(nums[s]);
		}
		return null;
	}
	
}
