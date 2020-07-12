package dynamicprogramming;

import java.util.Scanner;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        //dp[0] = num[0];
        dp[1] = Math.abs(num[0] - num[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(num[i] - num[i - 1]),
                    dp[i - 2] + Math.abs(num[i] - num[i - 2]));
        }

        //System.out.println(dp[n-1]);
        System.out.println(helper(num, 0));


    }

    private static int helper(int[] num, int i) {
        if (i == num.length - 1) return 0;
        if( i == num.length - 2) return Math.abs(num[i] - num[i+1]);

        int opt1 = Math.abs(num[i] - num[i + 1]) + helper(num, i + 1);
        int opt2 = Math.abs(num[i] - num[i + 2]) + helper(num, i + 2);

        return Math.min(opt1, opt2);
    }
}
