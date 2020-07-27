package dynamicprogramming;

import java.util.Scanner;

public class F_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();

        System.out.println(LCS(s.toCharArray(), t.toCharArray()));
    }

    private static String LCS(char[] s, char[] t) {
        int m = s.length, n = t.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String res = "";
        int i = m, j = n;
        // Reconstructing the solution
        while (i > 0 && j > 0) {
            if (s[i - 1] == t[j - 1]) {
                res += s[i - 1];
                i--;
                j--;
            } else if (dp[i][j - 1] == dp[i][j]) {
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) {
                i--;
            }
        }
        return new StringBuilder(res).reverse().toString();
    }
}
