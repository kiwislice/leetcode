package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class NumberOfBoomerangs {

	public static void main(String[] args) {
		int[][] points = {{0,0},{1,0},{2,0}};
		
		System.out.println(numberOfBoomerangs(points));
	}

	// 106 ms faster than 73.67%
	public static int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> m = new HashMap<>(points.length);
		int count = 0;
		
		for(int i=0;i<points.length;i++) {
			int[] pi = points[i];
			for(int j=0;j<points.length;j++) {
				int[] pj = points[j];
				int dis = dis2(pi, pj);
				int c = m.getOrDefault(dis, 0);
				if( c>=1 )
					count += c;
				m.put(dis, c+1);
			}
			m.clear();
		}
		return count*2;
	}

	// 120 ms faster than 64.82%
	public static int numberOfBoomerangsOld(int[][] points) {
		Map<Integer, Integer> m = new HashMap<>(points.length);
		int count = 0;
		
		for(int i=0;i<points.length;i++) {
			int[] pi = points[i];
			for(int j=0;j<points.length;j++) {
				int[] pj = points[j];
				int dis = dis2(pi, pj);
				m.put(dis, m.getOrDefault(dis, 0)+1);
			}
			
			for(int d:m.values()) {
				if( d>=2 ) {
					count += d*(d-1);
				}
			}
			m.clear();
		}
		return count;
	}

	public static int dis2(int[] p1, int[] p2) {
		int x = p1[0]-p2[0];
		int y = p1[1]-p2[1];
		return x*x+y*y;
	}
	
}
