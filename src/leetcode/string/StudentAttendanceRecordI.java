package leetcode.string;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 */
public class StudentAttendanceRecordI {

	public static void main(String[] args) {
		// true
		String s = "PPALLP";

		System.out.println(checkRecord(s));
	}

	public static boolean checkRecord(String s) {
		if( s==null || s.length()==0 )
			return true;
		
		int a = 0;
		int lcount = 0;
		for(int i=0;i<s.length();i++) {
			if( s.charAt(i)=='A' ) {
				a++;
				if( a>1 )
					return false;
			}
				
			if( s.charAt(i)=='L' ) {
				lcount++;
				if( lcount>2 )
					return false;
			}
			else {
				lcount = 0;
			}
		}
		return true;
	}

}
