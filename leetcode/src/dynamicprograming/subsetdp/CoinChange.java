package dynamicprograming.subsetdp;

import java.util.Arrays;

public class CoinChange {
    private Integer[][] dp;

    //
    public static int coinChange89(int[] coins, int amount) {
        // dp [i] is optimal minimum coins to make "i" amount from coins set
        // which depends on optimal coins "i - cj" amount
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // double counting is there here because the question says so
        // minimum of double counting will also give minimum
        for (int i = 1; i <= amount; i++) { // for money from 1 to amount
            for (int j = 0; j < coins.length; j++) { // using each coin
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // top down
    // truly the topdown of abov
    // meh, not truly coz truly will be starting from last index
    public static int coinChange12s(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        return helper78(coins, amount, dp);
    }

    public static int helper78(int[] coins, int amt, Integer[] dp) {
        if (amt < 0)
            return -1;
        if (amt == 0)
            return 0;

        if (dp[amt] != null)
            return dp[amt];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int res = helper78(coins, amt - coins[j], dp);
            if (res == -1) continue;
            min = Math.min(min, res + 1);
        }

        dp[amt] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amt];
    }

    public static int coinChange123(int[] coins, int amount) {
        // dp [i] is optimal minimum coins to make "i" amount from coins set
        // which depends on optimal coins "i - cj" amount
        int max = amount + 1;

        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 1; i <= amount; i++) { // for money from 1 to amount
            Arrays.fill(dp[i], max);
            for (int j = 1; j <= coins.length; j++) { // using each coin
                dp[i][j] = dp[i][j - 1];
                if (i >= coins[j - 1])
                    dp[i][j] = Math.min(dp[i][j], dp[i - coins[j - 1]][j] + 1);
            }
        }
        return dp[amount][coins.length] == amount + 1 ? -1 : dp[amount][coins.length];
    }

    // top down
    public static int coinChange12(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        return helper(coins, 0, amount, dp);
    }

    public static int helper(int[] coins, int i, int amt, int[][] dp) {
        if (amt < 0)
            return -1;
        if (amt == 0)
            return 0;

        if (dp[i][amt] != 0)
            return dp[i][amt];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int res = helper(coins, j, amt - coins[j], dp);
            if (res >= 0 && min > res)
                min = res + 1;
            dp[j][amt] = (min == Integer.MAX_VALUE) ? -1 : min;
        }

        dp[i][amt] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[i][amt];
    }

    public static int coinChange234(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int s = 1; s <= amount; s++) {
                if (s >= coins[i]) {
                    int preChoose = dp[s - coins[i]];
                    if (preChoose == Integer.MAX_VALUE)
                        continue;
                    dp[s] = Math.min(preChoose + 1, dp[s]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        int max = amount + 1;

        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], max);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int s = 1; s <= amount; s++) {
                dp[i][s] = dp[i - 1][s];
                if (s >= coins[i - 1])
                    dp[i][s] = Math.min(dp[i][s], 1 + dp[i][s - coins[i - 1]]);
            }
        }

        return dp[coins.length][amount] == max ? -1 : dp[coins.length][amount];
    }

    public static int coinChangeIter(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int s = 1; s <= amount; s++) {
                if (s >= coins[i]) {
                    dp[s] = Math.min(dp[s - coins[i]] + 1, dp[s]);
                }
            }
        }

        if (dp[amount] == amount + 1)
            return -1;

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println((coinChange12(new int[]{1, 2, 3}, 5)));
    }

    public int coinChangeRecursiveTakeSkip(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins.length == 0)
            return -1;
        dp = new Integer[coins.length][amount + 1];
        int res = coinChangeFrom(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int coinChangeFrom(int[] coins, int amount, int currentIndex) {
        if (amount == 0)
            return 0;

        if (amount < 0 || currentIndex == coins.length)
            return Integer.MAX_VALUE;

        if (dp[currentIndex][amount] != null)
            return dp[currentIndex][amount];

        // Recursive call after selecting the coin at the currentIndex
        int count1 = Integer.MAX_VALUE;
        int res = coinChangeFrom(coins, amount - coins[currentIndex], currentIndex);
        if (res != Integer.MAX_VALUE) {
            count1 = res + 1;
        }

        // Recursive call after excluding the coin at the currentIndex
        int count2 = coinChangeFrom(coins, amount, currentIndex + 1);

        return dp[currentIndex][amount] = Math.min(count1, count2);
    }

}
