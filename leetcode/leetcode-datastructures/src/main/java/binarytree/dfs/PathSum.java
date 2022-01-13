package binarytree.dfs;

import commons.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        return hasPathSum1(root, 0, sum);
    }

    public boolean hasPathSum1(TreeNode root, int curr, int sum) {
        if (root == null) return false;

        curr += root.val;
        if (root.left == null && root.right == null) return curr == sum;

        return hasPathSum1(root.left, curr, sum) || hasPathSum1(root.right, curr, sum);
    }
}
