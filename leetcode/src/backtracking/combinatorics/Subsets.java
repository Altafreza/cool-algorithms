package backtracking.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(n);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets1(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subsets213(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void subsets(int[] nums, List<List<Integer>> res,
                         List<Integer> subset, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subsets(nums, res, subset, i + 1);
        subset.add(nums[i]);
        subsets(nums, res, subset, i + 1);
        subset.remove(subset.size() - 1);


    }

    private static void subsets213(int[] nums, List<List<Integer>> res, List<Integer> subset, int start) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets213(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
