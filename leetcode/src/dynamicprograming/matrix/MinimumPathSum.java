package dynamicprograming.matrix;

public class MinimumPathSum {
    public static int minPathSum(int[][] A) {
        return helper(A, 0, 0, new int[A.length][A[0].length]);
    }

    public static int helper(int[][] a, int i, int j, int dp[][]) {
        if (i == a.length - 1 && j == a[0].length - 1) return a[i][j];
        if (i == a.length || j == a[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = a[i][j] + Math.min(helper(a, i + 1, j, dp), helper(a, i, j + 1, dp));

        return dp[i][j];

    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 2, 5},
                {3, 2, 1}
        }));
    }
}
