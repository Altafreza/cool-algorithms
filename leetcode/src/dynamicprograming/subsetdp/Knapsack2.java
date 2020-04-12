package dynamicprograming.subsetdp;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        long[] ws = new long[n];
        int[] vs = new int[n];

        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(maxKnapsack2D(ws, vs, w));
    }


    private static long maxKnapsack1D(long[] ws, int[] vs, int w) {
        int totVal = 0;
        for (int v : vs) totVal += v;
        long[] dp = new long[totVal + 1];

        Arrays.fill(dp, w + 1);
        dp[0] = 0;
        for (int i = 0; i < ws.length; i++) {
            for (int s = totVal; s >= 0; s--) {
                if (s >= vs[i])
                    dp[s] = Math.min(dp[s - vs[i]] + ws[i], dp[s]);
            }
        }

        long res = 0;
        for (int i = 0; i <= totVal; i++) {
            if (dp[i] <= w) {
                res = Math.max(res, i);
            }
        }
        return res;
    }

    private static long maxKnapsack2D(long[] ws, int[] vs, int w) {
        int totVal = 0;
        for (int v : vs) totVal += v;
        long[][] dp = new long[ws.length + 1][totVal + 1];

        Arrays.fill(dp[0], w + 1);
        dp[0][0] = 0;
        for (int i = 1; i <= ws.length; i++) {
            for (int s = totVal; s >= 0; s--) {
                dp[i][s] = dp[i - 1][s];
                if (s >= vs[i - 1])
                    dp[i][s] = Math.min(dp[i - 1][s - vs[i - 1]] + ws[i-1], dp[i][s]);
            }
        }
        long res = 0;
        for (int i = 0; i <= totVal; i++) {
            if (dp[ws.length][i] <= w) {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
