package binarytree.dfs;

import commons.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        else if (p != null && q != null) {
            return p.val == q.val &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }

        return false;
    }
}
