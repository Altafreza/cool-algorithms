package dynamicprograming.treedp;

import commons.TreeNode;

import java.util.HashMap;

public class MaximumPathSum {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    // 2nd solution dfs
    int maxRes;

    public int maxPathSum(TreeNode root) {
        map.put(null, 0);
        buildDP(root);
        return max;
    }

    public void buildDP(TreeNode root) {
        if (root == null)
            return;
        else if (map.containsKey(root))
            return;
        else {
            buildDP(root.left);
            buildDP(root.right);
            int temp = Math.max(Math.max(map.get(root.left), map.get(root.right)), 0) + root.val;
            max = Math.max(max, root.val + Math.max(map.get(root.left), 0) + Math.max(map.get(root.right), 0));
            map.put(root, temp);
            return;
        }
    }

    public int maxPathSum2(TreeNode root) {
        maxRes = Integer.MIN_VALUE;
        maxSumPathMain(root);
        return maxRes;
    }

    public int maxSumPathMain(TreeNode root) {
        if (root == null) return 0;
        int leftSum = maxSumPathMain(root.left);
        int rightSum = maxSumPathMain(root.right);
        int c0 = root.val;
        int c1 = root.val + leftSum;
        int c2 = root.val + rightSum;
        int c3 = root.val + rightSum + leftSum;
        maxRes = Math.max(maxRes, Math.max(c0, Math.max(c1, Math.max(c2, c3))));
        int curr = root.val + Math.max(Math.max(0, leftSum), rightSum);
        return curr;
    }
}
