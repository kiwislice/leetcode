package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 6 ms
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		
		Queue<TreeNode> row = new LinkedList<>();
		if( root!=null )
			row.add(root);
		
		while(!row.isEmpty()) {
			double d = 0;
			int size = row.size();
			for(int i=0;i<size;i++) {
				TreeNode n = row.poll();
				d += n.val;
				if( n.left!=null )
					row.add(n.left);
				if( n.right!=null )
					row.add(n.right);
			}
			list.add(d/size);
		}
		
		return list;
	}

	// 15 ms
	public List<Double> averageOfLevelsByBfs(TreeNode root) {
		List<Double> list = new ArrayList<>();
		
		List<TreeNode> rowP = new LinkedList<>();
		List<TreeNode> rowC = new LinkedList<>();
		if( root!=null )
			rowP.add(root);
		
		while(!rowP.isEmpty()) {
			double d = 0;
			for(TreeNode n:rowP) {
				d += n.val;
				if( n.left!=null )
					rowC.add(n.left);
				if( n.right!=null )
					rowC.add(n.right);
			}
			d /= rowP.size();
			list.add(d);
			
			rowP.clear();
			rowP.addAll(rowC);
			rowC.clear();
		}
		
		return list;
	}

}
