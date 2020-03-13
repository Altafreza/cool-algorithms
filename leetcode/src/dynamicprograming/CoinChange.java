package dynamicprograming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/discuss/420334/JAVA-2d-DP-with-graph-explanation
 * 
 * @author Rakuten
 *
 */
public class CoinChange {
	// bottom up
	public int coinChangee(int[] coins, int amount) {
		// dp [i] is optimal minimum coins to make "i" amount from coins set
		// which depends on optimal coins "i - cj" amount
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) { // for money from 1 to amount
			for (int j = 0; j < coins.length; j++) { // using each coin
				if (i >= coins[j])
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

	// top down
	public int coinChangeR(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		helper(coins, amount, dp);
		return dp[amount];
	}

	public int helper(int[] coins, int amt, int[] dp) {
		if (amt < 0)
			return -1;
		if (amt == 0)
			return 0;

		if (dp[amt] != 0)
			return dp[amt];
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < coins.length; j++) {
			int res = helper(coins, amt - coins[j], dp);
			if (res >= 0 && min > res)
				min = res + 1;
		}

		dp[amt] = (min == Integer.MAX_VALUE) ? -1 : min;
		return dp[amt];
	}

	public int coinChange23(int[] coins, int amount) {
		int[] f = new int[amount + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				if (f[j - coins[i]] != Integer.MAX_VALUE) {
					f[j] = Math.min(f[j], f[j - coins[i]] + 1);
				}
			}
		}
		return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
	}

	// top down
	public static int coinChange(int[] coins, int amount) {
		int[][] dp = new int[coins.length][amount + 1];
		helper(coins, 0, amount, dp);
		return dp[coins.length - 1][amount];
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

		// dp[i][amt] = (min == Integer.MAX_VALUE) ? -1 : min;
		return min;
	}
	
	public static int coinChange43(int[] coins, int amount) {
		int[][] f = new int[coins.length + 1][amount + 1];
		for (int[] a : f)
			Arrays.fill(a, Integer.MAX_VALUE);
		for (int i = 0; i <= coins.length; i++) {
			f[i][0] = 0;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				f[i][j] = f[i - 1][j];
				if (j >= coins[i - 1]) {
					if (f[i][j - coins[i - 1]] != Integer.MAX_VALUE)
						f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
				}

			}
		}
		return f[coins.length][amount] == Integer.MAX_VALUE ? -1 : f[coins.length][amount];
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 5 };
		System.out.println(coinChange(a, 6));
		System.out.println(coinChange43(a, 11));
	}
}
