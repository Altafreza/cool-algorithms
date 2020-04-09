package dynamicprograming.subsetdp;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{3, 2, 7}, 6));
    }
    /*
     * f(nums, i, x) = for all j != i and j > i {f(nums, j, x - nums[i])}
     * de
     */

    private static boolean isSubsetSum(int[] nums, int x) {
        Boolean[][] dp = new Boolean[nums.length][x + 1];

        //return helper(nums, 0, x, dp);
        boolean b = helper1(nums, nums.length - 1, x, dp);
        return b;
    }

    private static boolean helper(int[] nums, int i, int x, Boolean[][] dp) {
        if (x == 0)
            return true;
        if (x < 0 || i >= nums.length)
            return false;

        if (dp[i][x] != null)
            return dp[i][x];

        boolean res = false;

        for (int j = i; j < nums.length; j++) {
            res = res || helper(nums, j + 1, x - nums[j], dp);
            dp[j][x] = res;
        }

        dp[i][x] = res;
        return res;
    }

    private static boolean helper1(int[] nums, int i, int x, Boolean[][] dp) {
        if (x == 0)
            return true;
        if (x < 0 || i < 0)
            return false;

        if (dp[i][x] != null)
            return dp[i][x];

        boolean res = false;

        for (int j = i; j >= 0; j--) {
            res = res || helper1(nums, j - 1, x - nums[j], dp);
            dp[j][x] = res;
        }

        dp[i][x] = res;
        return res;
    }

    public static boolean canPartition(int[] num, int sum) {
        int n = num.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is
        // equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    // else include the number and see if we can find a subset to get the remaining
                    // sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }
        // the bottom-right corner will have our answer.
        return dp[num.length - 1][sum];
    }
}
