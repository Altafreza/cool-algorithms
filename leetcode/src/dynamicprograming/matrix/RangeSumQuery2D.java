package dynamicprograming.matrix;

public class RangeSumQuery2D {
    private int[][] dp;

    // dp like min sum path prefix sum is stored
    public RangeSumQuery2D(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        RangeSumQuery2D q = new RangeSumQuery2D(a);
        q.sumRegion(2, 1, 4, 3); //-> 8
        q.sumRegion(1, 1, 2, 2); //-> 11
        q.sumRegion(1, 2, 2, 4); //-> 12
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }

}
