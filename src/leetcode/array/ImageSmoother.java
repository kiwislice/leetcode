package leetcode.array;

/**
 * https://leetcode.com/problems/image-smoother/
 */
public class ImageSmoother {

	public static void main(String[] args) {
		int[][] M = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		System.out.println(imageSmoother(M));
	}

	public static int[][] imageSmoother(int[][] M) {
		final int nrow = M.length;
		final int ncol = M[0].length;
		int[][] rtn = new int[nrow][ncol];

		for (int r = 0; r < nrow; r++) {
			for (int c = 0; c < ncol; c++) {
				// 15 ms
//				rtn[r][c] = smooth(M, r, c);
				// 15 ms
				rtn[r][c] = smoothMine(M, r, c, nrow, ncol);
			}
		}
		return rtn;
	}

	public static int smooth(int[][] M, int x, int y) {
		int nx = M.length;
		int ny = M[0].length;
		int sum = 0;
		int count = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x + i < 0 || x + i >= nx || y + j < 0 || y + j >= ny) {
					continue;
				}
				count++;
				sum += M[x + i][y + j];
			}
		}

		return sum / count;
	}

	public static int smoothMine(int[][] M, int r, int c, int maxR, int maxC) {
		int sr = r == 0 ? 0 : r - 1;
		int er = r == maxR - 1 ? maxR - 1 : r + 1;
		int sc = c == 0 ? 0 : c - 1;
		int ec = c == maxC - 1 ? maxC - 1 : c + 1;
		int sum = 0;

		for (int rr = sr; rr <= er; rr++) {
			for (int cc = sc; cc <= ec; cc++) {
				sum += M[rr][cc];
			}
		}

		return sum / ((er - sr + 1) * (ec - sc + 1));
	}

	// 39 ms
	public static int[][] imageSmootherOld(int[][] M) {
		final int nrow = M.length;
		final int ncol = M[0].length;
		int[][] rtn = new int[nrow][ncol];

		int sr, er, sc, ec;
		for (int r = 0; r < nrow; r++) {
			for (int c = 0; c < ncol; c++) {
				sr = r == 0 ? 0 : r - 1;
				er = r == nrow - 1 ? nrow - 1 : r + 1;
				sc = c == 0 ? 0 : c - 1;
				ec = c == ncol - 1 ? ncol - 1 : c + 1;

				for (int rr = sr; rr <= er; rr++) {
					for (int cc = sc; cc <= ec; cc++) {
						rtn[r][c] += M[rr][cc];
					}
				}
				rtn[r][c] /= (er - sr + 1) * (ec - sc + 1);
			}
		}
		return rtn;
	}

}
