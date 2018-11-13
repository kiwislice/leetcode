package leetcode.array;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if( n==0 )
			return true;
		if( flowerbed.length==1 )
			return flowerbed[0]==0 && n<=1;
		
		int count = 0;
		int conitinueZCount = 0;
		
		if( flowerbed[0]==0 && flowerbed[1]==0 ) {
			flowerbed[0] = 1;
			count++;
		}
		if( flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0 ) {
			flowerbed[flowerbed.length-1] = 1;
			count++;
		}
		
		for(int i=0;i<flowerbed.length;i++) {
			if( flowerbed[i]==0 ) {
				conitinueZCount++;
			}
			else {
				if( conitinueZCount>=3 ) {
					count += (conitinueZCount-1)/2;
				}
				conitinueZCount = 0;
			}
		}
		
		return n<=count;
	}

}
