package dynamicprograming.stringdp;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatchDP("aa", "*"));
    }

    private static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];

        int pre = 0;
        for (int i = 0; i < p.length(); i++) {
            pre = i;
            if (p.charAt(i) != '*') {
                pre = i - 1;
                break;
            }
        }

        return helper(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1, pre, dp);
    }

    private static boolean helper(char[] s, char[] p, int i, int j, int pre, Boolean[][] dp) {
        if (i < 0 & j < 0) return true;
        else if (j < 0) return false;
        else if (i < 0) return j <= pre;

        if (dp[i][j] != null) return dp[i][j];

        Boolean res = false;
        if (p[j] == '?') {
            res = helper(s, p, i - 1, j - 1, pre, dp);
        } else if (p[j] == '*') {
            // opt1 -- s[i] matches ""
            // opt2 -- s[i] matches p[j] we again use '*', again and again
            res = helper(s, p, i, j - 1, pre, dp) || helper(s, p, i - 1, j, pre, dp);
        } else if (s[i] == p[j]) {
            res = helper(s, p, i - 1, j - 1, pre, dp);
        }

        dp[i][j] = res;
        return res;
    }

    private static boolean isMatchDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        char[] sC = s.toCharArray();
        char[] pC = p.toCharArray();

        dp[0][0] = true;
        for (int j = 1; j <= pC.length; j++) {
            dp[0][j] = dp[0][j - 1] && pC[j - 1] == '*';
        }
        for (int i = 1; i <= sC.length; i++) {
            for (int j = 1; j <= pC.length; j++) {
                if (pC[j - 1] == '?' || sC[i - 1] == pC[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pC[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[sC.length][pC.length];
    }

    private static boolean isMatchDP2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        int pre = 0;
        char[] sC = s.toCharArray();
        char[] pC = p.toCharArray();
        for (int i = 0; i < pC.length; i++) {
            pre = i;
            if (p.charAt(i) != '*') {
                pre = i - 1;
                break;
            }
        }

        dp[0][0] = true;
        for (int i = 0; i <= sC.length; i++) {
            for (int j = 1; j <= pC.length; j++) {
                if (i == 0) {
                    if (j - 1 <= pre)
                        dp[i][j] = true;
                } else if (pC[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pC[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (sC[i - 1] == pC[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sC.length][pC.length];
    }


}
