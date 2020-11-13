package binarytree.divideandconquer;

import commons.TreeNode;

/*Is the binary tree height balanced*/
public class BalancedBinaryTree {
    // can be O(N^2) if done wrong
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false; // this stops further recursion and makes O(N) for now
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    /* Divide and Conquer using an object
     * O(n) time because height and status are kept in one state
     */
    public boolean isBalanced(TreeNode root) {
        return getBalancedWithHeightStatus(root).balanced;
    }

    private BalancedWithHeightStatus getBalancedWithHeightStatus(TreeNode root) {
        if (root == null) return new BalancedWithHeightStatus(true, 0);

        BalancedWithHeightStatus leftResult = getBalancedWithHeightStatus(root.left);
        if (!leftResult.balanced)
            return new BalancedWithHeightStatus(false, -1);

        BalancedWithHeightStatus rightResult = getBalancedWithHeightStatus(root.right);

        int diff = Math.abs(rightResult.height - leftResult.height);
        return new BalancedWithHeightStatus(rightResult.balanced && diff <= 1,
                1 + Math.max(leftResult.height, rightResult.height));
    }

    // state object
    private static class BalancedWithHeightStatus {
        public boolean balanced;
        public int height;

        public BalancedWithHeightStatus(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
}
