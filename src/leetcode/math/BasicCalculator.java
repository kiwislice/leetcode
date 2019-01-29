package leetcode.math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {

	public static void main(String[] args) {
//		String s = " 1 + 1 ";
//		String s = " 2-1 + 2 ";
		String s = "(1+(4+5+2)-3)+(6+8)";

		System.out.println(calculate(s));
	}

	/** 20 ms, faster than 39.27% */
	public static int calculate(String s) {
		Deque<Part> dq = new LinkedList<>();
		
		char[] car = s.toCharArray();
		int i = 0;
		while( i<car.length ) {
			// (, +, -直接放
			if( car[i]=='(' || isOpera(car[i]) ) {
				dq.addFirst(new Part(car[i++]));
			}
			// 數字取得後往左運算，結果放堆疊頂
			else if( isDigit(car[i]) ) {
				int j = i+1;
				// 取得完整數值字串
				while( j<car.length && isDigit(car[j]) ) {j++;};
				int sum = Integer.parseInt(s.substring(i, j));
				i = j;
				
				// 如果有運算子取出前一個數值運算，每次遇到數字都做，保證堆疊頂部數字最多只有1個
				Part op = dq.peekFirst();
				if( op!=null && op.isOpera() ) {
					op = dq.removeFirst();
					Part n = dq.removeFirst();
					sum = op.num=='+'?sum+n.num:n.num-sum;
				}
				dq.addFirst(new Part(sum));
			}
			// 遇到)不放，保證堆疊頂只有1個數字及對應的(，這次的()處理完還要往前看有無運算子
			else if( car[i]==')' ) {
				Part sumPart = dq.removeFirst();
				int sum = sumPart.num;
				// 移除這次對應的(
				dq.removeFirst();
				
				// 如果有運算子取出前一個數值運算，每次遇到數字都做，保證堆疊頂部數字最多只有1個，再來就是清空或是還沒處理的(
				Part op = dq.peekFirst();
				if( op!=null && op.isOpera() ) {
					op = dq.removeFirst();
					Part n = dq.removeFirst();
					sum = op.num=='+'?sum+n.num:n.num-sum;
				}
				dq.addFirst(new Part(sum));
				i++;
			}
			else {
				i++;
			}
		}
		return dq.removeFirst().num;
	}

	public static boolean isDigit(char c) {
		return c>='0' && c<='9';
	}

	public static boolean isOpera(char c) {
		return c=='+' || c=='-';
	}

	public static class Part {
		int num;
		char type;
		
		Part(char c){
			this.num = c;
			this.type = 'c';
		}

		Part(int n){
			this.num = n;
			this.type = 'i';
		}

		public boolean isDigit() {
			return type=='i';
		}

		public boolean isOpera() {
			return type=='c' && (num=='+' || num=='-');
		}

		public boolean isL() {
			return type=='c' && num=='(';
		}

		@Override
		public String toString() {
			return type=='c'?String.valueOf((char)num):String.valueOf(num);
		}

	}
	
}
