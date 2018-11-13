package leetcode.array;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
public class OneBitAnd2BitCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 3 ms
	public boolean isOneBitCharacter(int[] bits) {
		int firstZeroCount = 1;
		int firstOneCount = 0;
		for(int i=bits.length-2;i>=0;i--) {
			if( bits[i]==0 ) {
				if( firstOneCount>0 )
					break;
				firstZeroCount++;
				if( firstZeroCount>=2 )
					return true;
			}
			else {
				firstOneCount++;
			}
		}
		return firstOneCount%2==0;
	}

}
