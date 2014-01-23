package vamk.java.assignment1;

public class Application5 {

	public static void main(String[] args) {
		// Matrices dimension
		final int d = 3;

		int[][] m1 = new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };

		int[][] m2 = new int[][] { { 1, 1, 1 }, { 2, 2, 2 }, { 1, 1, 1 } };

		int[][] mAdd = new int[d][d];
		int[][] mSub = new int[d][d];
		int[][] mMul = new int[d][d];

		System.out.println("Calculating...");
		
		// Add/Substract matrices
		for (int x = 0; x < d; x++) {
			for (int y = 0; y < d; y++) {
				mAdd[x][y] = m1[x][y] + m2[x][y];
				mSub[x][y] = m1[x][y] - m2[x][y];
			}
		}
		
		// Multiply matrices
		for (int x = 0; x < d; x++) {
			for (int y = 0; y < d; y++) {
				for (int z = 0; z < d; z++) {
					mMul[x][y] += m1[x][z] * m2[z][y];
				}
			}
		}

		System.out.println("\nm1 + m2");
		printMatrix(mAdd);

		System.out.println("\nm1 - m2");
		printMatrix(mSub);

		System.out.println("\nm1 * m2");
		printMatrix(mMul);
	}

	public static void printMatrix(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}

}
