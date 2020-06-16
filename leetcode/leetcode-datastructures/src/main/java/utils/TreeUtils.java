package utils;

import commons.TreeNode;

import java.util.*;

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

    public static List<Integer> printLevelOrder(TreeNode treeNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(treeNode);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            res.add(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        TreeNode prev = null, curr = root;
        Deque<TreeNode> s = new ArrayDeque<>();
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            TreeNode peek = s.peek();
            if (peek.right == null || peek.right == prev) {
                res.add(peek.val);
                prev = s.pop();
            } else {
                curr = peek.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = constructBinaryTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 7, 8}));
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(list);
    }
}
