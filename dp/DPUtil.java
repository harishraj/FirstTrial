public class DPUtil {

	public static long factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public int fibonacciDP(int n) {
		int[] table = new int[n + 1];
		for (int i = 0; i < table.length; i++) {
			if (i == 0) {
				table[i] = 0;
			} else if (i == 1) {
				table[i] = 1;
			} else {
				table[i] = table[i - 2] + table[i - 1];
			}
		}

		return table[n];
	}

	public static long fib(int n) {
		if (n <= 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static long fibDP(int N) throws RuntimeException {

		if (N < 1 || N > 92) {
			throw new RuntimeException("N must be between 1 and 92");
		}

		long[] table = new long[N + 1];

		// base cases
		table[0] = 0;
		table[1] = 1;

		// bottom-up dynamic programming
		for (int n = 2; n <= N; n++)
			table[n] = table[n - 1] + table[n - 2];

		// print results
		System.out.println(table[N]);
		return table[N];
	}

	public static int GetMinCountCoins(int total, int[] coins, int length) {
	    int[] counts = new int[total + 1];
	    counts[0] = 0;
	    int MAX = 0x7FFFFFFF;

	    for(int i = 1; i <= total; ++ i) {
	        int count = MAX;
	        for(int j = 0; j < length; ++ j) {
	            if(i - coins[j] >= 0 && count > counts[i - coins[j]])
	                count = counts[i - coins[j]];
	        }

	        if(count < MAX)
	            counts[i] = count + 1;
	        else
	            counts[i] = MAX;
	    }

	    int minCount = counts[total];
	    return minCount;
	}

	public static void main(String[] args) {
		int numCoins;
		int[] array = {25, 10, 5, 1};
		numCoins = GetMinCountCoins(67, array, 4 );
		
		System.out.println("Number of coins : " + numCoins);
		
		long res = fibDP(24);
		long res1 = fib(24);
		System.out.println("Output of fib DP is " + res);
		System.out.println("Output of fib is " + res1);
		
	}
}
