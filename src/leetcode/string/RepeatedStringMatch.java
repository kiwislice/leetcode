package leetcode.string;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch {

	public static void main(String[] args) {
		// 3
		String A = "abcd", B = "cdabcdab";
		// 4
//		String A = "abc", B = "cabcabca";
		
		System.out.println(repeatedStringMatchByMyRabinKarpAlgorithm(A, B));
		System.out.println(repeatedStringMatchByRabinKarpAlgorithm(A, B));
		
	}

	public static int repeatedStringMatchByMyRabinKarpAlgorithm(String A, String B) {
		final int p = 113, MOD = 1073807359;
		final int base = '9';
		final int aLen = A.length(), bLen = B.length();
		int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();
		
		long hashB = 0, power = 1;
		for(int i=0;i<bLen;i++) {
			hashB += power * (B.codePointAt(i)-base);
			hashB %= MOD;
			power = (power * p)%MOD;
		}

		long hashA = 0; power = 1;
		for(int i=0;i<bLen;i++) {
			hashA += power * (A.charAt(i%A.length())-base);
			hashA %= MOD;
			power = (power * p)%MOD;
		}

		System.out.println("hashA="+hashA);
		System.out.println("hashB="+hashB);
		
		final int q = (bLen-1)/aLen + 1;;
		if( hashB==hashA && check(0, A, B) ) 
			return q; 
		
		power = (power * pInv)%MOD;
		for(int i=0;i<(q+1)*aLen-bLen;i++) {
			hashA -= A.charAt(i%aLen)-base;
			hashA *= pInv;
			hashA += power * (A.charAt((i+bLen)%aLen)-base);
			hashA %= MOD;
			
			if( hashB==hashA && check(i+1, A, B) ) 
				return q; 
		}
		return -1;
	}
	
	public static boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }
	
	// 12 ms
    public static int repeatedStringMatchByRabinKarpAlgorithm(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0; power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

		System.out.println("aHash="+aHash);
		System.out.println("bHash="+bHash);
		
        if (aHash == bHash && check(0, A, B)) return q;
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }
	
	// 180 ms
	public static int repeatedStringMatch(String A, String B) {
		if( A==null || B==null )
			return -1;
		if( A.length()>=B.length() ) {
			if( A.indexOf(B)!=-1 )
				return 1;
			return (A+A).indexOf(B)==-1?-1:2;
		}
		
		int times = B.length()/A.length() + (B.length()%A.length()==0?0:1) + 1;
		StringBuilder sb = new StringBuilder(A.length()*times);
		for(int i=0;i<times;i++)
			sb.append(A);
		
		int firstB = sb.indexOf(B);
		if( firstB==-1 )
			return -1;
		return sb.indexOf(A, firstB+B.length())==-1?times:times-1;
	}

}
