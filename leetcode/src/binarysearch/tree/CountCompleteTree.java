package binarysearch.tree;


import commons.TreeNode;
import utils.TreeUtils;

import java.util.Arrays;

public class CountCompleteTree {
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + height(root.left);
    }

    public static boolean isExist(TreeNode root, int node, int h) {
        if (root == null) return false;

        if (h == 1) return true;

        if (((node >> (h - 2)) & 1) == 1) {
            node = node % (int) Math.pow(2, h - 1);
            return isExist(root.right, node, h - 1);
        } else if (((node >> (h - 2)) & 1) == 0) {
            node = node % (int) Math.pow(2, h - 1);
            return isExist(root.left, node, h - 1);
        }
        return false;
    }

    public static int countNodes(TreeNode a) {
        int h = height(a);
        int penultimate = (int) Math.pow(2, h - 1) - 1;
        int low = 0, hi = (int) Math.pow(2, h - 1) - 1;
        if (a == null) return 0;
        if (h == 1) return 1;
        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (isExist(a, mid, h)) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return penultimate + low;
    }
    public static int countNodes2(TreeNode a) {
        int h = height(a);
        int penultimate = (int) Math.pow(2, h - 1) - 1;
        int low = 0, hi = (int) Math.pow(2, h - 1) - 1;
        if(a == null) return 0;if(h == 1) return 1;
        while (low < hi) {
            int mid = (low + hi) / 2 + 1;

            if (isExist(a, mid, h)) {
                low = mid;
            } else {
                hi = mid - 1;
            }
        }

        return penultimate + low + 1;
    }
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructBinaryTree(Arrays.asList(new Integer[]{1, 2, 3}));
        System.out.println(countNodes(root));
    }

}

