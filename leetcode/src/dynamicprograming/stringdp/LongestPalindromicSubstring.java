package dynamicprograming.stringdp;

public class LongestPalindromicSubstring {
    public String longestPalindrome1(String s) {
        int n = s.length();
        if (n < 1)
            return s;
        boolean[][] dp = new boolean[n][n];
        String str = String.valueOf(s.charAt(0));

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                str = s.substring(i, i + 2);
            }

        }

        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n; i++) {
                int j = Math.min(n - 1, i + k);
                if (i + 1 < n && dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (str.length() < j - i + 1)
                        str = s.substring(i, j + 1);
                }
            }
        }

        return str;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        boolean[][] dp = new boolean[n][n];
        int res_i = 0, res_j = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = (j - i) < 3 ? s.charAt(i) == s.charAt(j) : dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) {
                    if (res_j - res_i + 1 < j - i + 1) {
                        res_j = j;
                        res_i = i;
                    }
                }
            }
        }

        return s.substring(res_i, res_j + 1);
    }
}
