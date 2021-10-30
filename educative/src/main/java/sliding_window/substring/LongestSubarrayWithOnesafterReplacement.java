package sliding_window.substring;

public class LongestSubarrayWithOnesafterReplacement {
    public int longestOnes(int[] nums, int k) {
        int l = 0, max = 0, maxOnes = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 1) {
                maxOnes++;
            }

            if (r - l + 1 - maxOnes > k) {
                if (nums[l] == 1)
                    maxOnes--;
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
