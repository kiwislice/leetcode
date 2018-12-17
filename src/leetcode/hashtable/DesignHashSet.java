package leetcode.hashtable;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashset/
 */
public class DesignHashSet {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		hashSet.contains(1);    // returns true
		hashSet.contains(3);    // returns false (not found)
		hashSet.add(2);          
		hashSet.contains(2);    // returns true
		hashSet.remove(2);          
		hashSet.contains(2);    // returns false (already removed)

	}

	// 105 ms, faster than 44.36%
	static class MyHashSet {

		private boolean[] ar;
		
	    /** Initialize your data structure here. */
	    public MyHashSet() {
	    	 ar = new boolean[1000000+1];
	    }
	    
	    public void add(int key) {
	    	ar[key] = true;
	    }
	    
	    public void remove(int key) {
	    	ar[key] = false;
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	    	return ar[key];
	    }
	    
	}
	
	// 138 ms, faster than 18.78%
	static class MyHashSetOld {

		private int[] ar;
		private int size;
		
	    /** Initialize your data structure here. */
	    public MyHashSetOld() {
	    	 ar = new int[256];
	    }
	    
	    public void add(int key) {
	    	int i = Arrays.binarySearch(ar, 0, size, key);
	    	if( i>=0 ) return ;
	    	
	    	if( size==ar.length ) {
	    		ar = Arrays.copyOf(ar, ar.length*2);
	    	}
	    	
	    	int insert = -i-1;
	    	System.arraycopy(ar, insert, ar, insert+1, size-insert);
	    	ar[insert] = key;
	    	size++;
	    }
	    
	    public void remove(int key) {
	    	int i = Arrays.binarySearch(ar, 0, size, key);
	    	if( i<0 ) return ;
	    	
	    	System.arraycopy(ar, i+1, ar, i, size-i-1);
	    	ar[size-1] = 0;
	    	size--;
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	    	int i = Arrays.binarySearch(ar, 0, size, key);
	    	return i>=0;
	    }
	    
	}
	
}
