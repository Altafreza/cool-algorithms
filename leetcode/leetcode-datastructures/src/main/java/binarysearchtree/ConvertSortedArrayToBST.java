package binarysearchtree;

import commons.TreeNode;

// minimum height bst construction
// height balanced ==> (height diff <= 1)
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int i, int j) {
        if (i > j) return null;

        int mid = mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid - 1);
        root.right = helper(nums, mid + 1, j);
        return root;
    }

    public TreeNode helper1(int[] nums, int i, int j) {
        if (i > j) return null;

        int mid = 0;
        if ((j - i) % 2 == 0) mid = (i + j) / 2;
        else mid = (i + j) / 2 + 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper1(nums, i, mid - 1);
        root.right = helper1(nums, mid + 1, j);
        return root;

    }
}
