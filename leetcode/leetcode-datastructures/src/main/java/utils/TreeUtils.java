package utils;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
    public static TreeNode constructBinaryTree(List<Integer> treeValues) {
        TreeNode root = new TreeNode(treeValues.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < treeValues.size(); i++) {
            TreeNode curr = queue.poll();
            if (treeValues.get(i) != null) {
                curr.left = new TreeNode(treeValues.get(i));
                queue.offer(curr.left);
            }
            if (++i < treeValues.size() && treeValues.get(i) != null) {
                curr.right = new TreeNode(treeValues.get(i));
                queue.offer(curr.right);
            }
        }
        return root;
    }

}
