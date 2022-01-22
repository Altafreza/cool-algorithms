package binarytree.dfs;

import commons.TreeNode;

public class DiameterOfTree {
    public static void main(String[] args) {


    }

    // O(N) using oop
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }

    private Pair helper(TreeNode root) {
        if (root == null) return new Pair(0, 0); // base case
        // Pair of left subtree
        Pair left = helper(root.left);
        // Pair of right subtree
        Pair right = helper(root.right);

        Pair p = new Pair();
        p.height = Math.max(right.height, left.height) + 1;

        int d1 = left.height + right.height;
        int d2 = left.diameter;
        int d3 = right.diameter;

        p.diameter = Math.max(Math.max(d1, d2), d3);

        return p;

    }

    static class Pair {
        int height;
        int diameter;

        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

        public Pair() {

        }
    }
}
