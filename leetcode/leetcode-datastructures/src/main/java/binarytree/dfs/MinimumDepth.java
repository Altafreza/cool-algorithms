package binarytree.dfs;

import commons.TreeNode;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        //base case
        if (root == null)
            return 0;
        //if there is only right child get depth of it
        if (root.left == null)
            return minDepth(root.right) + 1;
            //similarly if there is only left child  get depth of it
        else if (root.right == null)
            return minDepth(root.left) + 1;
        //in case there are both  get the min of both
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}
