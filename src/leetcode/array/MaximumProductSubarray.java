package leetcode.array;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {-3,0,1,-2}));
		
	}
	
	public static int maxProduct(int[] nums) {
		if( nums.length==1 )
			return nums[0];
		
		int length = reduce(nums);
		if( length==0 )
			return 1;
		if( length<nums.length )
			nums[length] = 0;
		
		int max = length==nums.length?Integer.MIN_VALUE:1;
		for(int i=0;i<length;i++) {
			max = Math.max(max, findForOne(nums, i));
		}
		return max;
	}
	
	public static int reduce(int[] ar) {
		int index = 0;
		for(int i=0;i<ar.length;i++) {
			if( ar[i]!=1 )
				ar[index++] = ar[i];
		}
		
		int len = index;
		index = 0;
		for(int i=0;i<len;i++) {
			if( i<len-1 && ar[i]==-1 && ar[i+1]==-1 ) {
				i++;
			}
			else {
				ar[index++] = ar[i];
			}
		}
		
		return index;
	}
	
	public static int findForOne(int[] ar, int index) {
		if( ar[index]==0 )
			return 0;
		
		int max = ar[index];
		int product = ar[index];
		// left
		for(int i=index-1;i>=0;i--) {
			if( ar[i]==0 )
				break;
			
			product *= ar[i];
			max = Math.max(max, product);
		}
		
		// right
		product = ar[index];
		for(int i=index+1;i<ar.length;i++) {
			if( ar[i]==0 ) {
				break;
			}
			
			product *= ar[i];
			max = Math.max(max, product);
		}
		
		return max;
	}

}
