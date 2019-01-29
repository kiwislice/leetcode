package leetcode.heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KthLargestElementInAStream {

	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
	}

	/** 74 ms, faster than 93.00% */
	static class KthLargest {

		final int k;
		final PriorityQueue<Integer> pq;
		
	    public KthLargest(int k, int[] nums) {
	        this.k = k;
	        pq = new PriorityQueue<>(k);
	        
	        for(int n:nums) {
	        	put(n);
	        }
	    }
	    
	    public int add(int val) {
	    	put(val);
	    	return pq.peek();
	    }
	    
	    private void put(int v) {
	    	if( pq.size()<k )
	    		pq.add(v);
	    	else if( v>pq.peek() ) {
	    		pq.remove();
	    		pq.add(v);
	    	}
	    }
	    
	}
	
	
	/** 1009 ms, faster than 0.99% */
//	static class KthLargest {
//
//		final int k;
//		final TreeMap<Integer, Integer> m = new TreeMap<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//		});
//		
//	    public KthLargest(int k, int[] nums) {
//	        this.k = k;
//	        for(int n:nums) {
//	        	put(n);
//	        }
//	    }
//	    
//	    public int add(int val) {
//	    	put(val);
//	    	int _k = k;
//	    	for(Map.Entry<Integer, Integer> ent:m.entrySet()) {
//	    		_k -= ent.getValue();
//	    		if( _k<=0 )
//	    			return ent.getKey();
//	    	}
//	    	return -1;
//	    }
//	    
//	    private void put(int v) {
//	    	int count = m.getOrDefault(v, 0);
//        	m.put(v, count+1);
//	    }
//	    
//	}
	
}
