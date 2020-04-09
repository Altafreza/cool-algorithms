package dynamicprograming.subsetdp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        long[] ws = new long[n];
        int[] vs = new int[n];

        long[][] dp = new long[n][w + 1];
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        //System.out.println(maxKnapsack(ws, vs, 0, w, dp));
        System.out.println(maxKnapsack2(ws, vs, w));
    }


    private static long maxKnapsack2(long[] ws, int[] vs, int w) {
        int totVal = 0;
        for(int v : vs) totVal += v;
        long[] dp = new long[totVal + 1];

        Arrays.fill(dp, w+1);
        dp[0] = 0;
        for (int i = 0; i < ws.length; i++) {
            for (int s = totVal; s >= vs[i]; s--) {
                dp[s] = Math.min(dp[s - vs[i]] + ws[i], dp[s]);
            }
        }

        long res = 0;
        for(int i= 0;i <= totVal;i ++){
            if(dp[i] <= w){
                Math.max(res, i);
            }
        }
        return res;
    }
}
