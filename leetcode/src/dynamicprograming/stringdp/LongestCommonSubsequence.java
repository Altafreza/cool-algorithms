package dynamicprograming.stringdp;

public class LongestCommonSubsequence {
    public static int lcs(String a, String b) {
        int alen = a.length() - 1, blen = b.length() - 1;
        //dp[i][j] :: lcs of a[0..i] & b[0..j]
        //
        int[][] dp = new int[alen + 1][blen + 1];

        return lcs(a, b, alen, blen, dp);
    }

    private static int lcs(String a, String b, int i, int j, int[][] dp) {
        // i < 0 or j < 0 signifies lcs("", "xxxxxx") or lcs("xxxx", "")
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != 0)
            return dp[i][j];
        int res = Integer.MIN_VALUE;
        if (a.charAt(i) == b.charAt(j)) {
            res = 1 + lcs(a, b, i - 1, j - 1, dp);
        } else {
            //opt1 - if a[i] is not there it will not be in the lcs, no prob, still valid
            //opt2 - b[i] is not there in the lcs
            res = Math.max(lcs(a, b, i - 1, j, dp), lcs(a, b, i, j - 1, dp));
        }
        dp[i][j] = res;
        return res;
    }

    public static int longestCommonSubsequence(String a, String b) {
        int alen = a.length(), blen = b.length();
        int[][] dp = new int[alen + 1][blen + 1];
        // 1st row and col is 0 signifies lcs("", "xxxxxx") or lcs("xxxx", "")
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (a.charAt(i - 1) == (b.charAt(j - 1))) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[alen][blen];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abbcdgf", "bbadcgf"));
    }
}
