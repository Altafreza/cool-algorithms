package dynamicprograming;

public class MaxSubarray {
    public static int maxSubArray2(int[] nums) {
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    static int maxSubArrayRec(int[] a) {
        int n = a.length;
        return helper(a, n - 1, new int[n]);
    }

    private static int helper(int[] a, int i, int[] dp) {
        if (i < 0) return 0;

        if (dp[i] != 0) return dp[i];

        dp[i] = Math.max(a[i], a[i] + helper(a, i - 1, dp));

        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayRec(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
