package leetcode.stack;

import java.util.Collections;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack_ {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

	/** 82 ms, faster than 37.26% */
	static class MinStack {

		LinkedList<Integer> list = new LinkedList<>();
		Integer min = null;
		
	    /** initialize your data structure here. */
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	    	list.add(x);
	    	if( min==null || x<min )
	    		min = x;
	    }
	    
	    public void pop() {
	    	int rm = list.removeLast();
	    	if( rm==min ) {
	    		min = list.isEmpty()?null:Collections.min(list);
	    	}
	    }
	    
	    public int top() {
	    	return list.peekLast();
	    }
	    
	    public int getMin() {
	    	return min;
	    }
	    
	}
	
}
