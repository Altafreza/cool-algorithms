package binarytree.divideandconquer;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // Traversing
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, root, "");
        return res;
    }

    public void dfs(List<String> res, TreeNode root, String path) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(path + root.val);
            } else {
                dfs(res, root.left, path + root.val + "->");
                dfs(res, root.right, path + root.val + "->");
            }
        }
    }

    public List<String> binaryTreePathsDandC(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }

        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}
