package dynamicprogramming;

import java.io.*;
import java.util.*;

public class H_245 {
	public static void main(String[] args) throws IOException {
		input.init(System.in);
		PrintWriter out  = new PrintWriter((System.out));
		String s = input.next();
		Integer queries = input.nextInt();
		
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (j - i < 3) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
					}
				} else {
					if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
					}
				}

			}
		}

		/*
		 * System.out.print("	"); for(int i = 0; i < n; i++) {
		 * System.out.print(s.charAt(i) +"  "); }
		 * 
		 * System.out.println(); for(int i = 0; i < n; i++) {
		 * System.out.print(s.charAt(i) + "	"); for(int j = 0; j < n; j++) {
		 * System.out.print(dp[i][j] + "  "); } System.out.println(); }
		 */

		int[][] cache = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cache[i + 1][j + 1] = cache[i + 1][j] + cache[i][j + 1] - cache[i][j] + dp[i][j];
			}
		}
		/*
		 * System.out.println(); for(int i = 0; i <= n; i++) { for(int j = 0; j <= n;
		 * j++) { System.out.print(cache[i][j] + "  "); } System.out.println(); }
		 */

		
		
		
		for (int i = 0; i < queries; i++) {
			int a = input.nextInt() - 1;
			int b = input.nextInt() - 1;
			int res = 0;

			res += cache[b + 1][b + 1] - cache[a][b + 1] - cache[b + 1][a] + cache[a][a];
			out.println(res);
		}
		
		out.close();
		 
	}

}

class input {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			// TODO add check for eof if necessary
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static String nextLine() throws IOException {
		return reader.readLine();
	}
}
