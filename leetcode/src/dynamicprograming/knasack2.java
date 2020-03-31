package dynamicprograming;

import java.util.Scanner;

public class knasack2 {
    private static long maxKnapsack(int[] ws, long[] vs,int idx, int total, long[] dp) {
        if( total == 0) return 0;
        if(total < 0) return -1;

        if(dp[total] != 0)
            return dp[total];
        long max = Long.MIN_VALUE;

        for(int i = idx; i < ws.length; i++){
            long res = maxKnapsack(ws, vs, idx, total - ws[i], dp);
            if(res == -1) continue;
            else
                max = Long.max(max, vs[i] + res);
        }
        dp[total] = max;
        return dp[total];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        int[] ws = new int[n];
        long[] vs = new long[n];

        long[] dp = new long[w + 1];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        System.out.println(maxKnapsack(ws, vs,0, w, dp));
    }
}
