package binarytree.divideandconquer;

import commons.TreeNode;

public class BalancedBinaryTree2 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }


    //post order traversal
    private Node helper(TreeNode root) {
        if (root == null) return new Node(true, 0);

        //info from left subtree
        Node left = helper(root.left);
        //info from right subtree || recursion fairy | induction
        Node right = helper(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new Node(false, -1);
        }

        // now both left and right are balance time to check oneself and conquer
        int diff = Math.abs(right.height - left.height);
        return new Node(diff <= 1, 1 + Math.max(right.height, left.height));

    }

    // state object
    public class Node {
        int height;
        boolean isBalanced;

        Node(boolean isBalanced, int height) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
