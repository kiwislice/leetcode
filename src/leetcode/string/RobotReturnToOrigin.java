package leetcode.string;

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class RobotReturnToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 8 ms
	public boolean judgeCircle(String moves) {
		if( moves==null || moves.length()%2!=0 )
			return false;
		
		int ud = 0;
		int lr = 0;
		for(char c:moves.toCharArray()) {
			if( c=='U' )
				ud++;
			else if( c=='D' )
				ud--;
			else if( c=='L' )
				lr--;
			else if( c=='R' )
				lr++;
		}
		return ud==0 && lr==0;
	}

	// 14 ms
	public boolean judgeCircleOld(String moves) {
		if( moves==null || moves.length()%2!=0 )
			return false;
		
		int ud = 0;
		int lr = 0;
		for(int i=0;i<moves.length();i++) {
			if( moves.charAt(i)=='U' )
				ud++;
			else if( moves.charAt(i)=='D' )
				ud--;
			else if( moves.charAt(i)=='L' )
				lr--;
			else if( moves.charAt(i)=='R' )
				lr++;
		}
		return ud==0 && lr==0;
	}

}
