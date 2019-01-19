package leetcode.binarysearch;

public class FirstBadVersion {

	public static void main(String[] args) {
		int n = 2126753390;
		
		
		
		System.out.println(firstBadVersion(n));
	}

	/** 17 ms, faster than 95.87% */
	public static int firstBadVersion(int n) {
		int min = 1;
		int mid;
		Boolean minBad = null;
		Boolean nBad = null;
		
		while( n-min>1 ) {
			mid = (n-min)/2+min;
			boolean midBad = isBadVersion(mid);
			
			if( midBad ) {
				n = mid;
				nBad = midBad;
			} 
			else {
				min = mid;
				minBad = midBad;
			}
		}
		
		if( minBad==null )
			minBad = isBadVersion(min);
		if( nBad==null )
			nBad = isBadVersion(n);
		return minBad?min:n;
	}

	static boolean isBadVersion(int version) {
		return version>=1702766719;
	}
	
}
