package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(candidates, 0, res, new ArrayList<>(), target);
        return res;
    }

    static private void combinationSum(int[] nums, int index, List<List<Integer>> res, List<Integer> temp, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            temp.add(nums[i]);
            combinationSum(nums, i, res, temp, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }

    static private void combinationSum2(int[] nums, int i, List<List<Integer>> res, List<Integer> temp, int target) {
        if (target == 0) {


            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if (target > 0 && i < nums.length) {
            temp.add(nums[i]);
            combinationSum2(nums, i, res, temp, target - nums[i]);
            temp.remove(temp.size() - 1);
            combinationSum2(nums, i + 1, res, temp, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
