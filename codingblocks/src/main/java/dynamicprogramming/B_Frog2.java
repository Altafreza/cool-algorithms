package dynamicprogramming;

import java.util.Scanner;

public class B_Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[1] = Math.abs(num[0] - num[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j)
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(num[i] - num[i - j]));
            }
        }
        System.out.println(dp[n - 1]);
    }
}
