package binarytree.dfs;

import commons.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Traversals {
    // recursive solution
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversalIter(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.val);
            if (root.right != null) s.push(root.right);
            if (root.left != null) s.push(root.left);

        }
        return res;
    }

    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helperPre(root, res);
        return res;
    }

    public void helperPre(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        helperPre(root.left, res);
        helperPre(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
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
                prev = s.pop();
                res.add(peek.val);
            } else {
                curr = peek.right;
            }
        }

        return res;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {

        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            res.add(root.val);
        }
        return res;

    }
}
