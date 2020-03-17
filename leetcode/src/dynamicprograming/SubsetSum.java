package dynamicprograming;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{1, 2, 4, 5, 9}, 15));
    }
    /*
     * f(nums, i, x) = for all j != i and j > i {f(nums, j, x - nums[i])}
     *
     */

    private static boolean isSubsetSum(int[] nums, int x) {
        Boolean[][] dp = new Boolean[nums.length][x + 1];

        helper(nums, 0, x, dp);
        return false;
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
}
