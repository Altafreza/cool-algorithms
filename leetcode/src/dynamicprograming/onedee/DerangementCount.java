package dynamicprograming.onedee;

import java.util.Arrays;

public class DerangementCount {
    public static int countDerangements(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (dp[n] != -1) return dp[n];

        return dp[n] = (n - 1) * (helper(n - 1, dp) + helper(n - 2, dp));
    }

    public static void main(String[] args) {
        System.out.println(countDerangements(10));
    }
}
