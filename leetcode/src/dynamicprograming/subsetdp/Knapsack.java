package dynamicprograming.subsetdp;

import java.util.Scanner;

class Knapsack {
    private static long maxKnapsack(int[] ws, long[] vs, int idx, int total, long[][] dp) {
        if (total <= 0 || idx == ws.length) return 0;

        if (dp[idx][total] != 0) {
            return dp[idx][total];
        }
        long loot1 = 0;
        if (ws[idx] <= total)
            loot1 = vs[idx] + maxKnapsack(ws, vs, idx + 1, total - ws[idx], dp);

        dp[idx][total] = Math.max(loot1, maxKnapsack(ws, vs, idx + 1, total, dp));
        return dp[idx][total];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        int[] ws = new int[n];
        long[] vs = new long[n];

        long[][] dp = new long[n][w + 1];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(maxKnapsack(ws, vs, 0, w, dp));
        //System.out.println(maxKnapsack1(ws, vs, w));
    }

    private static long maxKnapsack(int[] ws, long[] vs, int w) {
        long[] dp = new long[w + 1];

        for (int i = 0; i < ws.length; i++) {
            for (int s = w; s >= ws[i]; s--) {
                dp[s] = Math.max(dp[s - ws[i]] + vs[i], dp[s]);
            }
        }
        return dp[w];
    }

    // non repeating non double counting
    private static long maxKnapsack1(int[] ws, long[] vs, int w) {
        long[][] dp = new long[ws.length + 1][w + 1];

        for (int i = 1; i <= ws.length; i++) {
            for (int s = 1; s <= w; s++) {
                dp[i][s] = dp[i - 1][s];// not taking the curr obj and considering the previous objects for the same weight
                if (s >= ws[i - 1])
                    dp[i][s] = Math.max(dp[i - 1][s - ws[i - 1]] + vs[i - 1], dp[i][s]); // taking the curr obj but not repeating itself
                // not repeating as considering the previous objects for the remaining weight
            }
        }
        return dp[ws.length][w];
    }

    public int knapsack(int[] vs, int[] ws, int w) {
        int[] dp = new int[w + 1];

        for (int i = 1; i < ws.length; i++) {
            for (int j = w; j <= ws[i]; j++) {
                // dp[j] =
            }
        }

        return 0;
    }
}
































/*

3 8
3 30
4 50
5 60
*/
