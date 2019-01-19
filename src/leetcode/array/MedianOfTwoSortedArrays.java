package leetcode.array;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
//		int[] nums2 = {1,2};
//		int[] nums1 = {3,4,5};
//		int[] nums1 = {2,3,4,5,6,7,8,9};
//		int[] nums2 = {1};
		int[] nums2 = {1};
		int[] nums1 = {1};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	/** 
	 * 52 ms, faster than 63.86%
	 * 參考方法4 https://github.com/wind-liang/leetcode/blob/master/leetCode-4-Median-of-Two-Sorted-Arrays.md 
	 * */
	public static double findMedianSortedArraysByMath(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		final int m = nums2.length;
		
		if( m < n )
			return findMedianSortedArraysByMath(nums2, nums1);
		
		int iL = 0, iR = n;
		int i, j;
		while( iL <= iR ) {
			i = (iL + iR)/2;
			j = (n+m+1)/2-i;
			
			// i需要右移
			if( j!=0 && i!=n && nums2[j-1]>nums1[i] ) {
				iL = i + 1;
			}
			// i需要左移
			else if( i!=0 && j!=m && nums1[i-1]>nums2[j] ) {
				iR = i - 1;
			}
			// 處理i不需要或不能移動
			else {
				int maxL = Math.max(i==0?Integer.MIN_VALUE:nums1[i-1], j==0?Integer.MIN_VALUE:nums2[j-1]);
				int minR = Math.min(i==n?Integer.MAX_VALUE:nums1[i], j==m?Integer.MAX_VALUE:nums2[j]);
				return (n+m)%2==1?maxL:(maxL+minR)/2.0;
			}
		}
		return 0;
	}

	/**
	 * 53 ms, faster than 54.64%
	 * 參考方法3 https://github.com/wind-liang/leetcode/blob/master/leetCode-4-Median-of-Two-Sorted-Arrays.md 
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		final int m = nums2.length;
		final int k = (n+m+1)/2;
		
		double kth = getMergedKth(nums1, 0, nums1.length, nums2, 0, nums2.length, k);
		if( (n+m)%2==1 ) return kth;
		
		kth += getMergedKth(nums1, 0, nums1.length, nums2, 0, nums2.length, k+1);
		return kth/2;
	}

	public static double getMergedKth(int[] nums1, int s1, int n, int[] nums2, int s2, int m, int k) {
		if( s1==n )
			return nums2[s2+k-1];
		if( s2==m )
			return nums1[s1+k-1];
		if( k==1 )
			return Math.min(nums1[s1], nums2[s2]);
		
		// 每次推進其中一條k/2個
		int k_half = k/2;
		
		int i = s1+k_half>n?n:s1+k_half;
		int j = s2+k_half>m?m:s2+k_half;
		
		if( nums1[i-1]<=nums2[j-1] )
			return getMergedKth(nums1, i, n, nums2, s2, m, k-(i-s1));
		else 
			return getMergedKth(nums1, s1, n, nums2, j, m, k-(j-s2));
	}

	/** 46 ms, faster than 96.68% */
	public static double findMedianSortedArraysByForeach(int[] nums1, int[] nums2) {
		final int len = nums1.length + nums2.length;
		boolean isOdd = len%2==1;
		
		// 直接照順序取得最小的第len/2個
		int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
		int ai = 0, bj = 0;
		for(int count=0;count<=len/2;count++) {
			a = b;
			if( ai==nums1.length || bj==nums2.length ) {
				if( ai==nums1.length )
					b = nums2[bj++];
				else
					b = nums1[ai++];
			}
			else {
				if( nums1[ai]<=nums2[bj] )
					b = nums1[ai++];
				else 
					b = nums2[bj++];
			}
		}
		return isOdd?b:(a+b)*1.0/2;
	}

	public static double medianSortedArray(int[] nums, int s, int e) {
		int m = s + (e-s)/2;
		
		double rtn = nums[m];
		if( (e-s)%2!=0 ) {
			rtn += nums[m+1];
			rtn /= 2;
		}
		return rtn;
	}
	
}
