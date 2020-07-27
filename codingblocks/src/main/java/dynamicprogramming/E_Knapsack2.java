package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class E_Knapsack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        int[] ws = new int[n], vs = new int[n];

        int v = 0;

        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
            v += vs[i];
        }

        System.out.println(knapsack(ws, vs, w, v));

    }

    private static long knapsack(int[] ws, int[] vs, int w, int v) {
        int[][] dp = new int[ws.length + 1][v + 1];
        Arrays.fill(dp[0], w + 1);
        dp[0][0] = 0;
        for (int i = 1; i <= ws.length; i++) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= vs[i - 1])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - vs[i - 1]] + ws[i - 1]);
            }
        }


        long res = 0;
        for (int i = 0; i <= v; i++) {
            if (dp[ws.length][i] <= w) {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
