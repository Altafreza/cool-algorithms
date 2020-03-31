package dynamicprograming;

public class CombinationSumIV {
    /* Example for amount = 5 and 1, 2, 3
     * 1
     * 11 | 2
     * 111, 21 | 12 | 3
     * 1111, 211, 121 | 112, 22 | 13
     * 11111, 2111, 1211, 1121, 221, 131 | 1112, 212, 122 | 113, 23
     * */
    static public int combinationSum44(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // Double counting
        for (int i = 1; i <= target; i++) {
            for (int coin : nums) {
                if (i >= coin)
                    dp[i] = dp[i] + dp[i - coin]; // ways are added for for each sum "i"
            }
        }

        return dp[target];
    }

    static public int combinationSum45(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][target + 1];
        return helper(nums, target, dp, 0);
    }


    /*
     * can be brought from Combination sum we take 0 in each recursion to NOT avoid
     * duplicate permutation of same combination
     */
    static public int helper(int[] coins, int amt, Integer[][] dp, int i) {
        if (amt == 0)
            return 1;
        if (amt < 0 || i >= coins.length)
            return 0;

        if (dp[i][amt] != null)
            return dp[i][amt];
        int res = 0;
        for (int j = 0; j < coins.length; j++) {
            res += helper(coins, amt - coins[j], dp, j);
        }
        dp[i][amt] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(Integer.compare(combinationSum44(new int[]{1, 2, 3}, 4), 7));
    }
    public static int combinationSum4(int[] A, int sum) {
        int[][] solution = new int[A.length + 1][sum + 1];
        // if sum is 0 the we can make the empty subset to make sum 0
        for(int i=0;i<=A.length;i++){
            solution[i][0]=1;
        }
        //
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum;j++){
                //first copy the data from the top
                solution[i][j] = solution[i-1][j];

                //If solution[i][j]==false check if can be made
                if(solution[i][j]==0 && j>=A[i-1])
                    solution[i][j] = solution[i][j] + solution[i-1][j-A[i-1]];
            }
        }
        return solution[A.length][sum];
    }


}

