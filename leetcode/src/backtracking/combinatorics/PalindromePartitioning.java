package backtracking.combinatorics;

import java.util.ArrayList;
import java.util.List;

// Bactracking is basically enumerating the optimization or counting
// problem solved by dynamic programming
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        int n = s.length();
        palindromicSubstrings(s.toCharArray(), dp);
        //palindromicSubstrings(s.toCharArray(), 0, n - 1,dp);
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private static void helper(List<List<String>> res, List<String> path, Boolean[][] dp, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i] != null && dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                helper(res, path, dp, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // bottom up version to check if substrings are palindromic in O(n^2)
    // brute force will take o(n^3)
    private static void palindromicSubstrings(char[] s, Boolean[][] dp) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - j <= 2 || dp[j + 1][i - 1] != null && dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
    }

    // top down recursive
    private static boolean palindromicSubstrings(char[] s, int i, int j, Boolean[][] dp) {
        if (i > j) return true;
        if (dp[i][j] != null) return dp[i][j];
        boolean res = false;
        if (s[i] == s[j]) {
            if (palindromicSubstrings(s, i + 1, j - 1, dp))
                res = true;
        }
        // traverse anyways so that we get answers for inner substring
        // whether they are palindromic or not
        palindromicSubstrings(s, i, j - 1, dp);
        palindromicSubstrings(s, i + 1, j, dp);
        dp[i][j] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

}
