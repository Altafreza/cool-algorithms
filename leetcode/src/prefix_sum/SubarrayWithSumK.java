package prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumK {
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int i = 0, j = 0;
        int sum = 0;
        while (i < n) {
            if (sum < k) {
                sum += nums[i];
                i++;
            }
            while (sum > k) { // start removing from the front
                sum -= nums[j];
                j++;
            }
            if (sum == k) {
                for (int p = j; p < i; p++) {
                    count++;
                }
                return count;
            }
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // memo initialize

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            // storing the count of subarrays starting at this prefix sum
            // and resulting to 'k'
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
