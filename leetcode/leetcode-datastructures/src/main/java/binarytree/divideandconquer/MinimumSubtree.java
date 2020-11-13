package binarytree.divideandconquer;

import commons.TreeNode;

// Given a binary tree, find the subtree with minimum sum.
// Return the root of the subtree.
public class MinimumSubtree {
    TreeNode ret = null;
    int min = Integer.MAX_VALUE;

    // More of traversal and finding minimum
    public TreeNode minSubtree(TreeNode root) {
        helper(root);
        return ret;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int val = root.val + helper(root.left) + helper(root.right);
        if (min > val) {
            ret = root;
            min = val;
        }
        return val;
    }


    // Pure divide and conquer
    public TreeNode minSubtreeDC(TreeNode root) {

        return help(root).node;
    }

    private Result help(TreeNode root) {
        if (root == null)
            return new Result(null, Integer.MAX_VALUE, 0);

        // divide
        Result left = help(root.left);
        Result right = help(root.right);

        Result ret = new Result(root,
                left.subtreeSum + right.subtreeSum + root.val,
                left.subtreeSum + right.subtreeSum + root.val);

        // update if left subtree has smaller
        // minimum node/val and return that result
        if (ret.min > left.min) {
            ret.min = left.min;
            ret.node = left.node;
        }
        if (ret.min > right.min) {
            ret.min = right.min;
            ret.node = right.node;
        }
        return ret;
    }

    public static class Result {
        TreeNode node;
        // we want the current minimum so as
        // to update the new min when we find it
        int min;
        // we store the subtree sum
        // to sum it up with parent val and brother subtree
        int subtreeSum;

        public Result(TreeNode o, int min, int subtreeSum) {
            this.node = o;
            this.min = min;
            this.subtreeSum = subtreeSum;
        }
    }
}
