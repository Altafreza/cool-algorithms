package dynamicprograming.stringdp;

public class PalindromicPartioningII {

    public static int minCut(String s) {
        //new Integer[][] as memo table because null is a valid value showcasing
        // when it has not been computed/ filled yet it is null
        // otherwise it answer can be 0: not cuts/ >0: mincuts/
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        palindromicSubstrings(s, memo);
        return minCut(s.toCharArray(), n - 1, new Integer[n], memo);
    }

    // top down recursive
    private static int minCut(char[] s, int idx, Integer[] dp, Boolean[][] memo) {
        if (idx < 0) return -1;
        int res = Integer.MAX_VALUE;
        if (dp[idx] != null) return dp[idx];
        for (int i = idx; i >= 0; i--) {
            if (memo[i][idx])
                res = Math.min(res, minCut(s, i - 1, dp, memo) + 1);

        }
        dp[idx] = res;
        return res;

    }

    static boolean palindromicSubstrings(String str, Boolean[][] memo) {
        int n = str.length();
        // dp[i][j] : isPalindrome of string starting at i and ending at j
        // dp(i, j) :: s(i) == s(j) && dp(i + 1, j - 1) and then traverse to (
        return palindromicSubstrings(str.toCharArray(), 0, n - 1, memo);
    }

    // top down recursive
    private static boolean palindromicSubstrings(char[] s, int i, int j, Boolean[][] dp) {
        if (i > j) return true;
        // null values show that has not been computed yet
        // false is an answer rather if false was not computed yet
        // it would check the same computation again and again which would lead to
        // overlapping subproblem and TLE
        if (dp[i][j] != null) return dp[i][j];
        boolean res = false;
        if (s[i] == s[j]) {
            if (palindromicSubstrings(s, i + 1, j - 1, dp))
                res = true;
        }
        palindromicSubstrings(s, i, j - 1, dp);
        palindromicSubstrings(s, i + 1, j, dp);
        dp[i][j] = res;
        return res;
    }

    // top down recursive to check if a string is palindrome
    private static boolean isPalindrome(char[] s, int i, int j) {
        if (i >= j) return true;
        boolean res = false;
        res = s[i] == s[j] && isPalindrome(s, i + 1, j - 1);
        return res;


    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("aaaaabaaa"));
        System.out.println(minCut("aba"));
    }

    //bottom up dp
    public int minCut1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // build the dp matrix to hold the palindrome information
        // dp[i][j] represents whether s[i] to s[j] can form a palindrome
        Boolean[][] memo = new Boolean[n][n];
        palindromicSubstrings(s, memo);

        // res[i] represents the minimum cut needed
        // from s[0] to s[i]
        int[] res = new int[n];

        for (int j = 0; j < n; j++) {
            // by default we need j cut from s[0] to s[j]
            int cut = j;
            for (int i = 0; i <= j; i++) {
                if (memo[i][j]) {
                    // s[i] to s[j] is a palindrome
                    // try to update the cut with res[i - 1]
                    cut = Math.min(cut, i == 0 ? 0 : res[i - 1] + 1);
                }
            }
            res[j] = cut;
        }

        return res[n - 1];
    }
}
