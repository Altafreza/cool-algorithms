package dynamicprogramming;

import java.util.Scanner;

/*
 * 3
 * 0.30 0.60 0.80
 * */
public class I_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        Double[][] dp = new Double[n][(n + 1) / 2 + 1];
        System.out.println(coinsMajorityHeadProbablity(a, (n + 1) / 2, dp, 0));
    }

    private static Double coinsMajorityHeadProbablity(double[] a, int x, Double[][] dp, int i) {
        if (x == 0) return 1.0;
        if (i == a.length) return 0.0;

        if (dp[i][x] != null) return dp[i][x];
        double res = a[i] * coinsMajorityHeadProbablity(a, x - 1, dp, i + 1)
                + (1 - a[i]) * coinsMajorityHeadProbablity(a, x, dp, i + 1);
        dp[i][x] = res;
        return res;
    }
}
