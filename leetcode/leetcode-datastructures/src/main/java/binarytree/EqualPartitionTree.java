package binarytree;

import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class EqualPartitionTree {
    // O(n) space
    public int solve(TreeNode a) {
        Map<Integer, Integer> map = new HashMap<>();
        int tot = populate(a, map);
        // since total sum can also be zero
        if (tot == 0) return map.getOrDefault(tot, 0) > 1 ? 1 : 0;

        return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
    }

    public int populate(TreeNode a, Map<Integer, Integer> map) {
        if (a == null) return 0;
        int sum = a.val + populate(a.left, map) + populate(a.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
