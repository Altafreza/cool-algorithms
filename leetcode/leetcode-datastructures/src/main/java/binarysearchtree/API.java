package binarysearchtree;

import commons.TreeNode;

import java.util.Stack;

public class API {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBSTPreorder(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        helper(root, val);
        return root;
    }

    private void helper(TreeNode root, int val) {
        // base case 1
        if (root.right == null && val > root.val) {
            root.right = new TreeNode(val);
            return;
        }
        // base case 2
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val);
            return;
        }

        // recursive case
        if (val > root.val) {
            helper(root.right, val);
        } else {
            helper(root.left, val);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.val = inSucc(root.right);

            root.right = deleteNode(root.right, root.val);
        }
        return root;

    }

    // helper function to delete a node
    int inSucc(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    class BSTIterator {
        TreeNode root;
        Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            this.root = root;
            s = new Stack<>();
            helper(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (!s.isEmpty()) return s.pop().val;
            return 0;
        }

        public void helper(TreeNode root) {
            if (root == null) return;

            helper(root.right);
            s.push(root);
            helper(root.left);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !s.isEmpty();
        }
    }
}
