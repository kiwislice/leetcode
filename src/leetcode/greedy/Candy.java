package leetcode.greedy;

/**
 * https://leetcode.com/problems/candy/
 */
public class Candy {
	
	public static void main(String[] args) {
		// 18
		System.out.println(candy(new int[] {1,6,10,8,7,3,2}));
		
		
	}
	
	public static int candy(int[] ratings) {
		if( ratings==null || ratings.length==0 )
			return 0;
		if( ratings.length==1 )
			return 1;
		
		int[] status = new int[ratings.length];
		for(int i=0;i<ratings.length;i++) {
			if( isLocalMin(ratings, i) )
				status[i] = -1;
			else if( isLocalMax(ratings, i) )
				status[i] = 1;
		}
		
//		System.out.println(Arrays.toString(status));
		
		int rtn = 0;
		int lCount0 = 0;
		for(int i=0;i<status.length;i++) {
			if( status[i]<0 ) {
				rtn += 1;
				lCount0 = 0;
			}
			else if( status[i]==0 ) {
				lCount0++;
			}
			else {
				int rCount0 = rightCount0(status, i);
				int maxCount0 = Math.max(lCount0, rCount0);
				int minCount0 = Math.min(lCount0, rCount0);
				rtn += (4+maxCount0+2)*(maxCount0+1)/2;
				rtn += (2+minCount0+1)*minCount0/2;
				lCount0 = 0;
				i += rCount0;
			}
		}
		return rtn;
	}
	
	public static int rightCount0(int[] ar, int index) {
		if( index==ar.length-1 )
			return 0;
		int count = 0;
		for(int i=index+1;i<ar.length;i++) {
			if( ar[i]==0 )
				count++;
			else
				break;
		}
		return count;
	}
	
	public static boolean isLocalMin(int[] ar, int index) {
		if( index==0 )
			return ar[index]<=ar[index+1];
		if( index==ar.length-1 )
			return ar[index-1]>=ar[index];
		
		return ar[index-1]>=ar[index] && ar[index]<=ar[index+1];
	}

	public static boolean isLocalMax(int[] ar, int index) {
		if( index==0 )
			return ar[index]>ar[index+1];
		if( index==ar.length-1 )
			return ar[index-1]<ar[index];
		
		return ar[index-1] <= ar[index] && ar[index] >= ar[index+1] && (ar[index-1] < ar[index] || ar[index] > ar[index+1]);
	}
	
}
