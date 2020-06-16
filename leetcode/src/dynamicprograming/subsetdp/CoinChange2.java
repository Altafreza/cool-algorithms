package dynamicprograming.subsetdp;

// Number of ways to get coin change for a given amt
public class CoinChange2 {

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
        //since we starting with ith ele
        for (int j = i; j < coins.length; j++) {
            // which prevents double counting unlike combination sum 4
            // since we are sending j everytime but there is repitition
            res += helper2(coins, j, amt - coins[j], dp);
        }
        dp[i][amt] = res;
        return res;
    }


    public static int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        // int res = helper(coins, amount, dp, coins.length);
        int res = helper3(coins, amount, dp, 0);
        return res;
    }

    // COIN - AMOUNT 2D TOP DOWN BOTTOM UP
    // can be brought fro Combination sum
    // we take i in each recursion to avoid duplicate permutation of same
    // combination
    //
    public static int helper(int[] coins, int amt, Integer[][] dp, int i) {
        if (amt == 0)
            return 1; // when amt - coins[i] leads to this means we got a way
        if (amt < 0 || i <= 0)
            return 0; // i - 1 leads to this means no way

        if (dp[i][amt] != null)
            return dp[i][amt];

        // self work is simply adding
        int res = helper(coins, amt, dp, i - 1) + helper(coins, amt - coins[i - 1], dp, i);

        dp[i][amt] = res;
        return res;
    }

    public static int helper3(int[] coins, int amt, Integer[][] dp, int i) {
        if (amt == 0)
            return 1; // when amt - coins[i] leads to this means we got a way
        if (amt < 0 || i >= coins.length)
            return 0; // i - 1 leads to this means no way

        if (dp[i][amt] != null)
            return dp[i][amt];

        // self work is simply adding
        // use or not use a coin this is why we dont have double counting
        int res = helper(coins, amt, dp, i + 1) + helper(coins, amt - coins[i], dp, i);
        // simply like combination sum we can use the same coin more than once (2nd helper , i)

        dp[i][amt] = res;
        return res;
    }

    // Truly the bottom up for above top down
    public static int changen(int amount, int[] coins) {
        // dp[i][j] : the no. of ways to make amount j, using coins coins[0..i]
        // dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]
        int[][] dp = new int[coins.length + 1][amount + 1];
        //
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1; // we can make amt == 0 by 1 way
        }

        // for each coin we see that how many ways we can make amounts 0 to amt
        for (int i = 1; i <= coins.length; i++) {
            for (int s = 1; s <= amount; s++) {
                // previous no. of ways for the same amount but leaving the current coin
                // because that is also the no. of ways we can get the same amount(OR LOGIC)
                dp[i][s] = dp[i - 1][s];
                if (s >= coins[i - 1])
                    //it is enssured double counting is not happening here
                    // after making all the amounts using 1 coin in the
                    // next iteration of the outer loop the prev coin is never used
                    dp[i][s] += dp[i][s - coins[i - 1]];
                // [i][s - coin] because it can be use repeately
            }
        }

        return dp[coins.length][amount];
    }

    // 1D of above version
    // for each coin whether to take or not recursion to make each amount
    public static int change32(int target, int[] coins) {
        // dp[i] no of ways to make i amt using coins[0..i]
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // No Double counting
        // this replicates the below recursion
        // because for each coin we tend to make different amounts
        //  start to make  amts at coins[i]
        // and each coin can be used repeatedly
        for (int i = 0; i < coins.length; i++) {
            for (int s = coins[i]; s <= target; s++) {
                dp[s] = (dp[s] + dp[s - coins[i]]);
            }
        }

        return dp[target];
    }

    // this wont work here because of double counting
    // this works in case of combination sum iv
    // this has double counting in it
    public static int change89(int amount, int[] coins) {
        // dp [i] is optimal minimum coins to make "i" amount from coins set
        // which depends on optimal coins "i - cj" amount
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) { // for money from 1 to amount
            for (int j = 0; j < coins.length; j++) { // using each coin
                if (i >= coins[j])
                    dp[i] = dp[i] + dp[i - coins[j]];
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println((change89(5, new int[]{1, 2, 3})));
    }



    /*
     * COINS :: AMOUNT
     * why double counting is bad
     * Example for amount = 5 and 1, 2, 3

     * 1  <- for combination sum iv
     * 11 | 2
     * 111, 21 | 12 | 3
     * 1111, 211, 121, 31 | 112, 22 | 13
     * 11111, 2111, 1211, 311, 1121, 221, 131 | 1112, 212, 122, 32 | 113, 23
     *
     * 1
     * 11 | 2
     * 111| 12 | 3
     * 1111| 112, 22 | 13
     * 11111 | 1112, 122 | 113, 23 (change32 go vertical) check below
     *
     * amount :: coins
     * change32 no double counting because each coin is used to make all the amounts it can
     * and then never used
     * 1, 11, 111,   1111,    11111
     *     2,  12, 112,22, 1112,122
     *          3,     13,   113,23
     * Real Answer : 11111, 1112, 122, 113 ,23
     * */
}
