package dynamicprograming.subsetdp;

public class cc21 {
    private Integer[][] dp;
    private int inf = 0;

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        inf = amount + 1;
        int res = coinChangeFrom(coins, amount, 0);
        return res == amount + 1 ? -1 : res;
    }

    private int coinChangeFrom(int[] coins, int amount, int currentIndex) {
        if (amount == 0)
            return 0;

        if (amount < 0 || currentIndex == coins.length)
            return inf;

        if (dp[currentIndex][amount] != null)
            return dp[currentIndex][amount];

        // Recursive call after selecting the coin at the currentIndex
        int op1 = 1 + coinChangeFrom(coins, amount - coins[currentIndex], currentIndex);


        // Recursive call after excluding the coin at the currentIndex
        int op2 = coinChangeFrom(coins, amount, currentIndex + 1);
        dp[currentIndex][amount] = Math.min(op1, op2);
        return dp[currentIndex][amount];
    }
}
