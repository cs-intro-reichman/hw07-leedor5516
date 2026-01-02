/** Computes the binomial(n,k) function. */
public class Binomial {	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java Binomial n k");
			return;
		}
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);

		if (n <= 25) {
			System.out.println("binomial1(" + n + "," + k + ") = " + binomial1(n, k));
		} else {
			System.out.println("binomial1 skipped for n > 25 (too slow)");
		}
		System.out.println("binomial(" + n + "," + k + ") = " + binomial(n, k));
	}

	// Computes the Binomial function, basic version.
	public static long binomial1(int n, int k) {
		if (k > n) return 0L;
		if (k == 0 || n == 0) return 1L;
		return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
	 }
	
	// Computes the Binomial function, efficiently
	public static long binomial(int n, int k) {
		long[][] memo = new long[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				memo[i][j] = -1L;
			}
		}
		return binomial(n, k, memo);
	}

	private static long binomial(int n, int k, long[][] memo) {
		if (memo[n][k] != -1L) {
			return memo[n][k];
		}
		// Base case
		if (k > n) {
			memo[n][k] = 0L;
			return 0L;
		}
		// Another base case
		if (n == 0 || k == 0) {
			memo[n][k] = 1L;
			return 1L;
		}
		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}



