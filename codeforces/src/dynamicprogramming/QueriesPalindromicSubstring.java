package dynamicprogramming;

import utils.input;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * cf - 245/h
 */
public class QueriesPalindromicSubstring {
    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
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

        int[][] cache = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cache[i + 1][j + 1] = cache[i + 1][j] + cache[i][j + 1] - cache[i][j] + dp[i][j];
            }
        }

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

