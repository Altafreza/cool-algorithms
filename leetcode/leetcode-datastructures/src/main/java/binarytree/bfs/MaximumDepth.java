package binarytree.bfs;

import commons.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque(); // use deque as a queue
        deque.add(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            depth++;
            int numNodesInLevel = deque.size();
            while (numNodesInLevel > 0) {
                TreeNode n = deque.poll();
                // if (n.left == null && n.right == null) {
                //     return depth;
                // }
                if (n.left != null) {
                    deque.add(n.left);
                }
                if (n.right != null) {
                    deque.add(n.right);
                }
                numNodesInLevel--;
            }
        }
        return depth; // code will reach here
    }
}
