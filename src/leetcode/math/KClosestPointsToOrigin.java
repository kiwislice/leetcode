package leetcode.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** 49 ms, faster than 87.10% */
	public int[][] kClosestByTreeMap(int[][] points, int K) {
		TreeMap<Integer, int[]> m = new TreeMap<>();
		
		for(int i=0;i<points.length;i++) {
			int[] p = points[i];
			
			if( m.size()<K ) {
				m.put(dis(p), p);
			}
			else {
				int dis = dis(p);
				if( dis<m.lastKey() ) {
					m.pollLastEntry();
					m.put(dis, p);
				}
			}
		}
		
		return m.values().toArray(new int[][] {});
	}

	public static int dis(int[] p) {
		return p[0]*p[0]+p[1]*p[1];
	}
	
}
