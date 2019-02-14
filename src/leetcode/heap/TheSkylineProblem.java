package leetcode.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

	public static void main(String[] args) {
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		// [[1,1],[2,0],[2147483646,2147483647],[2147483647,0]]
//		int[][] buildings = {{1,2,1},{2147483646,2147483647,2147483647}};
		
		getSkyline(buildings).stream().map(Arrays::toString).forEach(System.out::println);
	}


	/**
	 * By 從左到右掃過
	 * 21 ms, faster than 88.53%
	 * 42.4 MB, less than 11.38%
	 * 參考https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
	 */
	public static List<int[]> getSkyline(int[][] buildings) {
		if( buildings==null || buildings.length==0 )
			return new LinkedList<>();
		
		List<int[]> rtn = new LinkedList<>();
		// 蒐集所有X點&高度
		List<int[]> height = new LinkedList<>();
		
		// 用-區分左右端點
		for(int[] p:buildings) {
			height.add(new int[] {p[0], -p[2]});
			height.add(new int[] {p[1], p[2]});
		}
		
		// 根據X從小到大，同X也從小到大(左端點優先)
		Collections.sort(height, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if( o1[0]!=o2[0] )
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		// 從左到右掃的過程中，存放當前X點上所有高度
		TreeMap<Integer, Integer> m = new TreeMap<>();
		m.put(0, 1);
		int lastH = 0;
		
		for(int[] p:height) {
			if( p[1]<0 ) {
				m.put(-p[1], m.getOrDefault(-p[1], 0)+1);
			}
			else {
				if( m.getOrDefault(p[1], 0)==1 ) {
					m.remove(p[1]);
				} else {
					m.put(p[1], m.get(p[1])-1);
				}
			}
			
			int max = m.lastKey();
			if( lastH!=max ) {
				rtn.add(new int[] {p[0], max});
				lastH = max;
			}
		}
		
		return rtn;
	}

	
	/**
	 * By 自訂物件
	 * 56 ms, faster than 77.36%
	 * 43 MB, less than 5.32%
	 */
	public static List<int[]> getSkylineByObj(int[][] buildings) {
		if( buildings==null || buildings.length==0 )
			return new LinkedList<>();
		
		// 取得所有X點
		int[] allX = new int[2*buildings.length];
		for(int i=0;i<buildings.length;i++) {
			allX[i*2] = buildings[i][0];
			allX[i*2+1] = buildings[i][1];
		}
		
		// 排序&去除重複
		int len = sortAndDistinct(allX);
		
		// 生出所有不重疊區段&各區段的平均數(搜尋用)
		Segment[] segments = new Segment[len-1];
		double[] mids = new double[len-1];
		for(int i=0;i<segments.length;i++) {
			segments[i] = new Segment(allX[i], allX[i+1]);
			mids[i] = (allX[i]*1.0+allX[i+1])/2.0;
		}
		
		// 對所有建築物找到最左側&最右側區段，將區段高度設定為最高的數值
		for(int[] p:buildings) {
			int L = Arrays.binarySearch(mids, p[0]);
			if( L<0 ) L = -(L+1);
			
			int R = Arrays.binarySearch(mids, L, mids.length, p[1]);
			if( R<0 ) R = -(R+1)-1;
			
			for(int i=L;i<=R;i++) {
				segments[i].height = Math.max(segments[i].height, p[2]);
			}
		}
		
		// 掃過所有區段，高度有變化表示要加新的點，最後補上結尾點
		List<int[]> rtn = new LinkedList<>();
		int lastH = 0;
		for(Segment seg:segments) {
			if( seg.height!=lastH ) {
				rtn.add(new int[] {seg.min, seg.height});
				lastH = seg.height;
			}
		}
		rtn.add(new int[] {segments[segments.length-1].max, 0});
		
		return rtn;
	}

	public static int sortAndDistinct(int[] allX) {
		Arrays.sort(allX);
		
		int count = 1;
		int last = allX[0];
		for(int i=1;i<allX.length;i++) {
			if( allX[i]!=last ) {
				allX[count++] = allX[i];
				last = allX[i];
			}
		}
		return count;
	}

	/** 一個區段 */
	static class Segment {
		int height;
		int max, min;
		
		public Segment(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "min="+min+", max="+max+", h="+height;
		}
		
	}
	
}
