package dynamicprograming.onedee;

import java.util.Arrays;

public class HouseRobber {

    //O(n) using maths
    public int rob1(int[] a) {
        int even = 0, odd = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0)
                even = Math.max(odd, even + a[i]);
            else
                odd = Math.max(even, odd + a[i]);
            System.out.println("i: " + i + " even: " + even + " odd: " + odd);

        }
        return Math.max(even, odd);
    }

    // O(n) bottom up from first house
    public int rob23(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // sentinal brain
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // recursive
        for (int i = 2; i < nums.length; i++) {
            // if i have the maximum till 'i-2'th house and 'i-1'th house
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    // O(n) bottom up from last housr
    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;
        int[] max = new int[nums.length];
        if (nums.length == 1) return nums[0];
        max[nums.length - 1] = nums[nums.length - 1];
        max[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i] + max[i + 2]);
        }
        return max[0];
    }

    // Recursive Memoized
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robHelper(nums, nums.length - 1);
    }

    public int robHelper(int[] nums, int i) {
        if (i < 0)
            return 0;

        if (memo[i] >= 0)
            return memo[i];

        int result = Math.max(nums[i] + robHelper(nums, i - 2), robHelper(nums, i - 1));
        memo[i] = result;
        return result;
    } // --> O(n) linear time


    // O(1) space Bottom up
    public int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int f1 = nums[0];
        int f2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // f(i) = max { f(i - 2) + nums[i], f(i - 1) }
            int f = Math.max(f1 + nums[i], f2);
            f1 = f2; // money in prev(alternate (n-2))
            f2 = f; // money stolen till now
        }
        return f2;

    }
}
