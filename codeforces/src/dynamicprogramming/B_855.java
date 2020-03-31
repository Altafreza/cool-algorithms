package dynamicprogramming;

import java.util.Scanner;

public class B_855{
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long p = sc.nextLong(), q = sc.nextLong(), r = sc.nextLong();
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextLong();
        }

        System.out.println(solve(ar, p, q, r));
    }

    public static long solve(long[] a, long b, long c, long d) {
        long[][] dp = new long[3][a.length];

        dp[0][0] = b * a[0];
        for (int i = 1; i < a.length; i++) {
            dp[0][i] = Long.max(dp[0][i - 1], b * a[i]);
        }

        dp[1][0] = dp[0][0] + c * a[0];
        for (int i = 1; i < a.length; i++) {
            dp[1][i] = Long.max(dp[1][i - 1], dp[0][i] + c * a[i]);
        }
        dp[2][0] = dp[1][0] + d * a[0];
        for (int i = 1; i < a.length; i++) {
            dp[2][i] = Long.max(dp[2][i - 1], dp[1][i] + d * a[i]);
        }
        return dp[2][a.length - 1];
    }
}