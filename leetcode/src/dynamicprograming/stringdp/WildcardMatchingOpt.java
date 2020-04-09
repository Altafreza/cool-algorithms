package dynamicprograming.stringdp;

public class WildcardMatchingOpt {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*"));
    }

    public static boolean isMatch(String s, String p) {
        // dp[i] maps to dp[i][j], where i is the length of s, j is the length of j
        boolean[] dp = new boolean[s.length() + 1];
        char[] sStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        // before we started any iteration, dp[0] is equal to dp[0][0], meaning both s and p are EMPTY
        dp[0] = true;
        for (int j = 1; j <= pStr.length; j++) {
            char pChr = pStr[j - 1];
            if (pChr == '*') {

/*
same optimization as complete backpack problem
we scan from 1 to s.length, so that dp[i] = dp[i] || dp[i-1]
just thinking like every time we iterating dp[i], the dp[i][j]
we referenced is actually previous iteration's result. so dp[i-1] is actually dp[i-1][j] from previous step of current i-loop for string s, dp[i] is actually dp[i][j-1] from previous j-loop for string p
it's relatively easy to understand that before the dp[i]'s value is updated, dp[i] refers to dp[i][j-1]
the hard to understand part may be why dp[i-1] equals to dp[i-1][j]. Notice dp[i-1]'s value was updated in previous step's update (we update dp[i-1] in dp[i-2]'s step), so dp[i-1] is equal to dp[i-1][j]
*/

                for (int i = 1; i <= sStr.length; i++) {
                    dp[i] = dp[i] || dp[i - 1];
                }
            } else {
                // same optimization as zero-one backpack
                // dp[i-1] means dp[i-1][j-1]
                for (int i = sStr.length; i >= 1; i--) {
                    if (sStr[i - 1] == pChr || pChr == '?') {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = false;
                    }
                }
                // now, after we see the first non-'*' character, as dp[0] means dp[i][0] where i>=1, dp[i][0] it's definite false (matching empty p with non-empty s)
                // we want to set that value to false
                dp[0] = false;
            }
        }
        return dp[sStr.length];
    }

    public boolean isMatch2D(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        char[] sStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        int pre = 0;
        for (int i = 0; i < p.length(); i++) {
            pre = i;
            if (p.charAt(i) != '*') {
                pre = i - 1;
                break;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (i - 1 <= pre) dp[i][0] = true;
        }

        for (int j = 1; j <= pStr.length; j++) {
            char pChr = pStr[j - 1];
            if (pChr == '*') {
                for (int i = 1; i <= sStr.length; i++) {
                    dp[j][i] = dp[j - 1][i] || dp[j][i - 1];
                }
            } else {
                for (int i = sStr.length; i >= 1; i--) {
                    if (sStr[i - 1] == pChr || pChr == '?') {
                        dp[j][i] = dp[j - 1][i - 1];
                    } else {
                        dp[j][i] = false;
                    }
                }
                dp[j][0] = false;
            }
        }
        return dp[p.length()][sStr.length];
    }
}
