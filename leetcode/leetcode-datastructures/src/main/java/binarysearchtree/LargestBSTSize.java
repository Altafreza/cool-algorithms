package binarysearchtree;

import commons.TreeNode;
import utils.TreeUtils;

import java.util.Arrays;

// Give a binary tree find the size of the largest BST
// example below
public class LargestBSTSize {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructBinaryTree(Arrays.
                asList(10, 15, 8, 12, 20, 5, 9, 2, 14, null, null, 4, 7, null, 10));
        TreeUtils.printLevelOrder(treeNode);


        System.out.println("The size of the largest BST is " +
                findLargestBST(treeNode)); // answer is 6
    }

    // Recursive function to find the size of the largest BST in a given binary tree
    public static SubTreeInfo findLargestBST(TreeNode root) {// Base case: empty tree
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        // Recur for the left and right subtrees
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);

        SubTreeInfo info = new SubTreeInfo();

        // Check if a binary tree rooted under the current root is a BST

        // 1. Left and right subtree are also BST
        // 2. The value of the root node should be more than the largest value
        //    in the left subtree
        // 3. The value of the root node should be less than the smallest value
        //    in the right subtree
        if (left.isBst && right.isBst &&
                (root.val > left.max && root.val < right.min)) {
            info.size = left.size + 1 + right.size;
            info.min = Math.min(root.val, Math.min(left.min, right.min));
            info.max = Math.max(root.val, Math.max(left.max, right.max));
            info.isBst = true;

        } else {
            // If a binary tree rooted under the current root is not a BST,
            // return the largest BST size in its left and right subtree
            info.size = Math.max(left.size, right.size);
            info.min = 0;
            info.max = 0;
            info.isBst = false;
        }

        return info;
    }


    static class SubTreeInfo {
        int size;
        int min;
        int max;
        boolean isBst;


        public SubTreeInfo() {

        }

        public SubTreeInfo(int min, int max, int size, boolean isBst) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBst = isBst;
        }
    }


// Construct the following tree
//                      10
//                    /    \
//                   /      \
//                  15       8
//                 / \      / \
//                /   \    /   \
//               12   20  5     9
//              / \      / \     \
//             /   \    /   \     \
//            2    14  4    7     10
}



