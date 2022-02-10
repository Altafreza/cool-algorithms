package prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumK {

    public static int subarraySum(int[] nums, int k) {
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

    public static void main(String[] args) {
        subarraySum(new int[]{-1, -1, 1}, 0);
    }
}
