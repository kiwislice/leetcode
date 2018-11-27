package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {

	public static void main(String[] args) {
		// 964176192
		int n = 43261596;
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(reverseBits(n));
		System.out.println(Integer.toBinaryString(reverseBits(n)));
	}

	// 2 ms
	public static int reverseBits(int n) {
		int rtn = 0;
		for(int i=0;i<32;i++) {
			rtn <<= 1;
			rtn += n&1;
			n >>>= 1;
		}
		return rtn;
	}

	// 1 ms
	public static int reverseBitsOld(int n) {
		n = (n & 0b11111111_11111111_00000000_00000000) >>> 16 | (n & 0b00000000_00000000_11111111_11111111) << 16;
		n = (n & 0b11111111_00000000_11111111_00000000) >>> 8  | (n & 0b00000000_11111111_00000000_11111111) << 8;
		n = (n & 0b11110000_11110000_11110000_11110000) >>> 4  | (n & 0b00001111_00001111_00001111_00001111) << 4;
		n = (n & 0b11001100_11001100_11001100_11001100) >>> 2  | (n & 0b00110011_00110011_00110011_00110011) << 2;
		n = (n & 0b10101010_10101010_10101010_10101010) >>> 1  | (n & 0b01010101_01010101_01010101_01010101) << 1;
		return n;
	}

}
