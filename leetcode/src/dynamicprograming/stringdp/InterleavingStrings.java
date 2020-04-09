package dynamicprograming.stringdp;

public class InterleavingStrings {
    String a, b, c;
    Boolean[][] dp;

    public boolean isInterleave(String A, String B, String C) {
        this.a = A;
        this.b = B;
        this.c = C;
        this.dp = new Boolean[a.length()][b.length()];
        int lcpA = 0, lcpB = 0;
        if (a.length() + b.length() != c.length()) return false;
        for (int j = 0; j < a.length(); j++) {
            lcpA = j;
            if (a.charAt(j) != c.charAt(j)) {
                lcpA = j - 1;
                break;
            }
        }
        for (int j = 0; j < b.length(); j++) {
            lcpB = j;
            if (b.charAt(j) != c.charAt(j)) {
                lcpB = j - 1;
                break;
            }
        }
        return helper(a.length() - 1, b.length() - 1, lcpA, lcpB);
    }

    public boolean helper(int i, int j, int lcpA, int lcpB) {
        if (i < 0 && j < 0) return true;
        if (i < 0) return b.substring(0, j + 1).equals(c.substring(0, j + 1));
        else if (j < 0) return a.substring(0, i + 1).equals(c.substring(0, i + 1));

        if (dp[i][j] != null) return dp[i][j];

        boolean res = false;
        if (c.charAt(i + j + 1) == b.charAt(j)
                && c.charAt(i + j + 1) == a.charAt(i)) {
            res = helper(i - 1, j, lcpA, lcpB) || helper(i, j - 1, lcpA, lcpB);
        } else if (c.charAt(i + j + 1) != b.charAt(j)
                && c.charAt(i + j + 1) == a.charAt(i)) {
            res = helper(i - 1, j, lcpA, lcpB);
        } else if (c.charAt(i + j + 1) == b.charAt(j) && c.charAt(i + j + 1) != a.charAt(i)) {
            res = helper(i, j - 1, lcpA, lcpB);
        }

        dp[i][j] = res;
        return res;
    }
}
