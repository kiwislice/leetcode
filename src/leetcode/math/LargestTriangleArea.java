package leetcode.math;

public class LargestTriangleArea {

	public static void main(String[] args) {
		int[][] ps = {{1,0},{0,0},{0,1}};
		System.out.println(largestTriangleArea(ps));

	}

	public static double largestTriangleArea(int[][] points) {
		double max = 0;
		for(int i=0;i<points.length-2;i++) {
			for(int j=i+1;j<points.length-1;j++) {
				for(int k=j+1;k<points.length;k++) {
					max = Math.max(max, area(points[i], points[j], points[k]));
				}
			}
		}
		return max;
	}

	public static double area(int[] a, int[] b, int[] c) {
		double area = (a[0]*(b[1]-c[1])+b[0]*(c[1]-a[1])+c[0]*(a[1]-b[1]))/2.0;
		return Math.abs(area);
	}
	
}
