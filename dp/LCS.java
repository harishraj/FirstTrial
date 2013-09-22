/**
 * Reads in two strings and computes their longest common subsequence.
 *  *************************************************************************/

public class LCS {

	public static String findLCS(String str1, String str2){
		int M = str1.length();
		int N = str2.length();

		// opt[i][j] = length of LCS of x[i..M] and y[j..N]
		int[][] opt = new int[M + 1][N + 1];

		// compute length of LCS and all subproblems via dynamic programming
		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j))
					opt[i][j] = opt[i + 1][j + 1] + 1;
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
			}
		}
		
		// recover LCS itself
		StringBuffer result = new StringBuffer();
		int i = 0, j = 0;
		while (i < M && j < N) {
			if (str1.charAt(i) == str2.charAt(j)) {
				result.append(str1.charAt(i));
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		return result.toString();

	}
	public static void main(String[] args) {
		String x = "ggcaccacg";
		String y = "acggcggatacg";
		String result = findLCS(x, y);
		System.out.println("LCS is : " + result);
	}
}