package binarytree.dfs;

import commons.TreeNode;

public class LowestCommonAncestor {
    // post order solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2 base cases
        if (root == null) return root;
        if (root == p || root == q) return root;

        // find p or q in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // find p or q in left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both found in the current subtree root is the lca
        if (left != null && right != null) return root;

        // either p or q found return the node p or q itself
        // or it can be the root(lca) of subtree which contains p and q
        return left != null ? left : right;
    }
}
