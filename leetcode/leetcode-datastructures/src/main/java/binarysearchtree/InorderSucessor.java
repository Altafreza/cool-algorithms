package binarysearchtree;

import commons.TreeNode;

public class InorderSucessor {
    // root travesal
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) {
            // find in right subtree
            return inorderSuccessor(root.right, p);
        }
        // find in left subtree
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }

    public TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p) {
        TreeNode temp = root;
        TreeNode succ = null;

        while (temp != null) {
            if (temp.val > p.val) {
                succ = temp; // will capture the next greater
                temp = temp.left;
            } else if (temp.val <= p.val) {
                temp = temp.right;
            }
        }
        return succ;
    }
}
