package dynamicprograming;

public class InterleavingStrings {
    String a, b, c;
    Boolean[][] dp;

    public boolean isInterleave(String A, String B, String C) {
        this.a = A;
        this.b = B;
        this.c = C;
        this.dp = new Boolean[a.length()][b.length()];
        if (a.length() + b.length() != c.length()) return false;
        return helper(a.length() - 1, b.length() - 1);
    }

    public boolean helper(int i, int j) {
        if (i < 0 && j < 0) return true;
        if (i < 0) return b.substring(0, j + 1).equals(c.substring(0, j + 1));
        else if (j < 0) return a.substring(0, i + 1).equals(c.substring(0, i + 1));

        if (dp[i][j] != null) return dp[i][j];

        boolean res = false;
        if (c.charAt(i + j + 1) != b.charAt(j) && c.charAt(i + j + 1) != a.charAt(i)) {
            res = false;
        } else if (c.charAt(i + j + 1) == b.charAt(j) && c.charAt(i + j + 1) == a.charAt(i)) {
            res = helper(i - 1, j) || helper(i, j - 1);
        } else if (c.charAt(i + j + 1) != b.charAt(j) && c.charAt(i + j + 1) == a.charAt(i))
            res = helper(i - 1, j);
        else if (c.charAt(i + j + 1) == b.charAt(j) && c.charAt(i + j + 1) != a.charAt(i)) {
            res = helper(i, j - 1);
        }

        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        InterleavingStrings i = new InterleavingStrings();
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
