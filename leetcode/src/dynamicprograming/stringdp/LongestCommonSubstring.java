package dynamicprograming.stringdp;

public class LongestCommonSubstring {
    Integer[][][] dp;

    public static int longestCommonSubstring1(String a, String b) {
        int m = a.length();
        int n = b.length();
        //dp = new Integer[m + 1][n + 1][Math.max(m, n)];
        return lcs(a.toCharArray(), b.toCharArray(), m - 1, n - 1);
    }

    static int lcs(char[] a, char[] b, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        //if (dp[i][j][count] != null) return dp[i][j][count];

        int lc = 0;
        if (a[i] == b[j]) {
            lc = 1 + lcs(a, b, i - 1, j - 1);
        } else {
            lc = Math.max(lcs(a, b, i, j - 1),
                    lcs(a, b, i - 1, j));
            //dp[i][j][count] = x;}
        }
        return lc;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring1("zxabcdezy", "yzabcdezx"));
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
