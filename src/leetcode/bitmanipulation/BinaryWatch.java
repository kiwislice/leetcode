package leetcode.bitmanipulation;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class BinaryWatch {

	public static void main(String[] args) {
		// ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
		int n = 2;

		System.out.println(readBinaryWatch(n).stream().sorted().collect(Collectors.toList()));
	}

	public static List<String> readBinaryWatch(int num) {
		List<String> rtn = new LinkedList<>();
		
		for(int h=0;h<12;h++) {
			for(int m=0;m<60;m++) {
				if( (Integer.bitCount(h)+Integer.bitCount(m))==num ) {
					// 14 ms
//					rtn.add(h+":"+String.format("%02d", m));
					// 3 ms
					rtn.add(h+":"+(m>9?m:"0"+m));
				}
			}
		}
		
		return rtn;
	}

	public static List<String> readBinaryWatchByForward(int num) {
		List<String> rtn = new LinkedList<>();
		
		final int[] allH = {8,4,2,1};
		final int[] allM = {32,16,8,4,2,1};
		
		for(int i=0;i<=num;i++) {
			List<Integer> hs = new LinkedList<>();
			run(allH, 0, i, 0, hs);
			List<Integer> ms = new LinkedList<>();
			run(allM, 0, num-i, 0, ms);
			
			for(int h:hs) {
				if( h>=12 ) continue;
				for(int m:ms) {
					if( m>=60 ) continue;
					// 13 ms
//					rtn.add(h+":"+String.format("%02d", m));
					// 2 ms
					rtn.add(h+":"+(m>9?m:"0"+m));
				}
			}
		}
		
		return rtn;
	}

	public static void run(int[] src, int from, int count, int sum, List<Integer> result) {
		if( count==0 ) {
			result.add(sum);
			return ;
		}
		
		for(int i=from;i<src.length;i++) {
			run(src, i+1, count-1, sum+src[i], result);
		}
	}
	
}
