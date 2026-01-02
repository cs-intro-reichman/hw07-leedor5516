/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java Binomial n k");
			return;
		}
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
	}

	// Computes the Binomial function, basic version.
	public static int binomial1(int n, int k) { 
		if (k > n) return 0;
		if (k == 0 || n == 0) return 1;
		return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
	 }
	
	// Computes the Binomial function, efficiently
	public static int binomial(int n, int k) {
		int[][] memo = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				memo[i][j] = -1;
			}
		}
		return binomial(n, k, memo);
	}

	private static int binomial(int n, int k, int[][] memo) {
		if (memo[n][k] != -1) {
			return memo[n][k];
		}
		// Base case
		if ((k > n)) {
		   	memo[n][k] = 0; 
		   	return 0;
		}
		// Another base case
		if (n == 0 || k == 0) {
		   	memo[n][k] = 1; 
		   	return 1;
		}
		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}



