package dynamicprograming;

import java.util.Arrays;

// Number of ways to get coin change for a given amt 
public class CoinChange2 {
	public static int change(int amount, int[] coins) {
		Integer[][] dp = new Integer[coins.length + 1][amount + 1];
		int res = helper(coins, amount, dp, coins.length);
		return res;
	}

	// can be brought fro Combination sum
	// we take i in each recursion to avoid duplicate permutation of same
	// combination
	//
	public static int helper(int[] coins, int amt, Integer[][] dp, int i) {
		if (amt == 0)
			return 1;
		if (amt < 0 || i <= 0)
			return 0;

		if (dp[i][amt] != null)
			return dp[i][amt];

		int res = helper(coins, amt, dp, i - 1) + helper(coins, amt - coins[i - 1], dp, i);

		dp[i][amt] = res;
		return res;
	}

	public static int changen(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		for (int i = 0; i <= coins.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int s = 1; s <= amount; s++) {
				dp[i][s] = dp[i - 1][s];
				if (s >= coins[i - 1])
					dp[i][s] += dp[i][s - coins[i - 1]];
			}
		}

		return dp[coins.length][amount];
	}

	public static int change2(int amount, int[] coins) {
		Integer[][] dp = new Integer[coins.length][amount + 1];
		int res = helper2(coins, 0, amount, dp);
		return res;

	}

	// can be brought fro Combination sum
	// we take i in each recursion to avoid duplicate permutation of same
	// combination
	//
	public static int helper2(int[] coins, int i, int amt, Integer[][] dp) {
		if (amt == 0)
			return 1;
		if (amt < 0 || i >= coins.length)
			return 0;

		if (dp[i][amt] != null)
			return dp[i][amt];
		int res = 0;
		for (int j = i; j < coins.length; j++) {
			res += helper2(coins, j, amt - coins[j], dp);
		}
		dp[i][amt] = res;
		return res;
	}

	public static int change32(int target, int[] coins) {
		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < target + 1; j++) {
				dp[j] = (dp[j] + dp[j - coins[i]]);
			}
		}

		return dp[target];
	}

	
	public static void main(String[] args) {
		System.out.println((change32(5, new int[] { 1, 2, 3 })));
	}

}
