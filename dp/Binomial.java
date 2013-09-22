public class Binomial {

	public static void main(String[] args) {
		long result = calculateBinomial(15, 16);
		System.out.println(result);
	}

	public static long calculateBinomial(int N, int K) {
		long[][] binomial = new long[N + 1][K + 1];

		// base cases
		for (int k = 1; k <= K; k++)
			binomial[0][k] = 0;
		for (int n = 0; n <= N; n++)
			binomial[n][0] = 1;

		// bottom-up dynamic programming
		for (int n = 1; n <= N; n++)
			for (int k = 1; k <= K; k++)
				binomial[n][k] = binomial[n - 1][k - 1] + binomial[n - 1][k];

		return binomial[N][K];
	}
}
