package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int curr = nums[i] + nums[l] + nums[r];
                if (curr < 0) {
                    l++;
                } else if (curr > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r - 1 && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                }
            }
        }

        return res;
    }
}
