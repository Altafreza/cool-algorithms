package binarysearchtree;

import commons.TreeNode;
import utils.TreeUtils;

import java.util.Arrays;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructBinaryTree(Arrays.asList(new Integer[]{3, 1, 4, null, 2}));
        System.out.println(validateBST(root));
    }

    private static boolean validateBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;

        return root.val > minValue && root.val < maxValue &&
                validateBST(root.left, minValue, root.val) &&
                validateBST(root.right, root.val, maxValue);
    }


    public static boolean validateBST(TreeNode tree) {
        return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
