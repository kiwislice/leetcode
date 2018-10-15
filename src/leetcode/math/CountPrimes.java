package leetcode.math;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {

	public static void main(String[] args) {
		// 1229
//		System.out.println(countPrimes(10000));
		// 41537
//		System.out.println(countPrimes(499979));
		
		System.out.println(countPrimes(10));
	}
	
	public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int res = 0;
        for(int i = 2 ; i < n ; i++){
            if(!prime[i]){
                res++;
                for(int j = i ; j < n ; j += i){
                    prime[j] = true;
                }
            }
        }
        return res;
    }
	
	static TreeSet<Integer> set;
	static {
		set = new TreeSet<>();
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(11);
		set.add(13);
		set.add(17);
		set.add(19);
		set.add(23);
	}
	
	public static int countPrimesByBruteForce(int n) {
		int count = 0;
		for(int i:set) {
			if( i<n )
				count++;
			else
				break;
		}
		
		if( set.last()>=n )
			return count;
		
		for(int i=set.last()+2;i<n;i+=2) {
			if( isPrime(i) ) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
		boolean isPrime = isPrimeBySet(n);
		if( !isPrime )
			return false;
		
		for(int i=set.last()+2;i<n/i;i+=2) {
			if( isPrimeBySet(i) ) {
				set.add(i);
				if( n%i==0 )
					return false;
			}
		}
		set.add(n);
		return true;
	}

	public static boolean isPrimeBySet(int n) {
		boolean isPrime = true;
		for(int p:set) {
			if( n%p==0 ) {
				return false;
			}
			if( p*p>n )
				return isPrime;
		}
		return true;
	}
	
}
