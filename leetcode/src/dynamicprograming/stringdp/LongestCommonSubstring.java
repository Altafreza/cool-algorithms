package dynamicprograming.stringdp;

public class LongestCommonSubstring {
    String X;
    String Y;
    Integer[][][] dp;

    public int longestCommonSubstring1(String A, String B) {
        this.X = A;
        this.Y = B;
        int m = A.length();
        int n = B.length();
        dp = new Integer[m + 1][n + 1][Math.max(m, n)];
        return lcs(m, n, 0);
    }

    int lcs(int i, int j, int count) {

        if (i <= 0 || j <= 0) {
            return count;
        }

        if (dp[i][j][count] != null) return dp[i][j][count];

        int lc = count;
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            lc = lcs(i - 1, j - 1, count + 1);
        }
        int x = Math.max(lc, Math.max(lcs(i, j - 1, 0),
                lcs(i - 1, j, 0)));
        dp[i][j][count] = x;
        return x;
    }

    public int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int max = 0;

        int[][] dp = new int[m][n];
        int endIndex = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {

                    // If first row or column
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Add 1 to the diagonal value
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = i;
                    }
                }

            }
        }
        // We want String upto endIndex, we are using endIndex+1 in substring.
        return max;
    }

}
