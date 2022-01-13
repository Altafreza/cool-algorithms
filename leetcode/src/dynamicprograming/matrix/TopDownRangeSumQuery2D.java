package dynamicprograming.matrix;

public class TopDownRangeSumQuery2D {
    Integer[][] dp;

    public TopDownRangeSumQuery2D(int[][] matrix) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return;
        }
        dp = new Integer[matrix.length][matrix[0].length];
        dpHelper(dp, matrix.length - 1, matrix[0].length - 1, matrix);
    }

    public int dpHelper(Integer[][] dp, int r, int c, int[][] matrix) {
        if (r < 0 || c < 0)
            return 0;

        if (dp[r][c] != null)
            return dp[r][c];
        return (dp[r][c] = dpHelper(dp, r, c - 1, matrix) + dpHelper(dp, r - 1, c, matrix)
                - ((r >= 1 && c >= 1) ? dp[r - 1][c - 1] : 0) + matrix[r][c]);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2] - (col1 >= 1 ? dp[row2][col1 - 1] : 0) - (row1 >= 1 ? dp[row1 - 1][col2] : 0)
                + ((row1 >= 1 && col1 >= 1) ? dp[row1 - 1][col1 - 1] : 0);
    }
}
