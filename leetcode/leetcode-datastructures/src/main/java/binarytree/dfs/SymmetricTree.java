package binarytree.dfs;

import commons.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftroot, TreeNode rightroot) {
        if (leftroot == null && rightroot == null) return true;

        else if (leftroot != null && rightroot != null) {
            return leftroot.val == rightroot.val &&
                    isSymmetric(leftroot.left, rightroot.right) &&
                    isSymmetric(leftroot.right, rightroot.left);
        }
        return false;
    }
}
