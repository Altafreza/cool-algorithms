package utils;

import binarytree.dfs.Traversals;
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

    public static TreeNode constructBinarySearchTree(List<Integer> treeValues) {
        TreeNode root = new TreeNode(treeValues.get(0));
        helper(treeValues, 1, root, null);
        return root;
    }

    private static void helper(List<Integer> treeValues, int i, TreeNode curr, TreeNode parent) {
        if (curr == null) return;

        if (treeValues.get(i) >= curr.val) {
            helper(treeValues, i + 1, curr.right, curr);
        } else {
            helper(treeValues, i + 1, curr.left, curr);
        }
        if (parent == null) parent = curr;
        else {
            if (treeValues.get(i) >= parent.val) {
                parent.right = new TreeNode();
                parent.right.val = treeValues.get(i);
                helper(treeValues, i + 1, parent.right, parent);

            } else {
                parent.left = new TreeNode();
                parent.left.val = treeValues.get(i);
                helper(treeValues, i + 1, parent.left, parent);

            }
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = constructBinaryTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 7, 8}));
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(list);

        TreeNode bstRoot = constructBinarySearchTree(Arrays.asList(new Integer[]{15, 10, 20, 8, 12, 16, 25}));
//        TreeNode bstRoot1 = buildTree(new int[]{15, 10, 20, 8, 12, 16, 25});

        System.out.println(new Traversals().inorderTraversal(bstRoot));
    }

    public static TreeNode buildTree(int[] a) {
        TreeNode parent = new TreeNode();
        TreeNode curr = new TreeNode();
        curr.val = a[0];
        TreeNode root = curr;
        int v;
        for (int i = 1; i < a.length; i++) {
            curr = root;
            v = a[i];
            while (curr != null) {
                if (v >= curr.val) {
                    parent = curr;
                    curr = curr.right;
                } else {
                    parent = curr;
                    curr = curr.left;
                }
            }
            //parent is leaf
            if (v >= parent.val) {
                parent.right = new TreeNode();
                parent.right.val = v;
            } else {
                parent.left = new TreeNode();
                parent.left.val = v;
            }
        }
        return root;
    }

}




