package binarytree.dfs;

import commons.TreeNode;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructBinaryTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
        postOrdIter(treeNode);
        List<Integer> list = TreeUtils.printLevelOrder(treeNode);
        System.out.println(list);
    }

    // post order recursion // no helper
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;

        // inverted right sub tree built
        TreeNode left = invertTree1(root.right);
        // inverted left sub tree built
        TreeNode right = invertTree1(root.left);

        // upon return from recursion
        // invert oneself
        root.left = left;
        root.right = right;
        // return root
        return root;
    }

    public static TreeNode postOrdIter(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // visiting leaf node or the node whose both subtrees are visted LRN
            // we are checking right with prev because we know that left has alreafy done
            if (stack.peek().right == null || stack.peek().right == prev) {
                // visit
                prev = stack.poll();
                TreeNode t = prev.left;
                prev.left = prev.right;
                prev.right = t;
            } else {
                cur = stack.peek().right;
            }
        }
        return root;
    }

    // post order recursion
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    // preorder traversal
    public static void preOrderRec(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return; //base case

        // pre-order work
        if (root.right != null && root.left != null) {
            // swapp nodes
            TreeNode node = root.right;
            root.right = root.left;
            root.left = node;
        } else if (root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
        } else {
            root.left = root.right;
            root.right = null;
        }
        // invert left subtree
        preOrderRec(root.left);
        // invert right subtree
        preOrderRec(root.right);
    }

    // same as below // no difference
    public TreeNode preorderIterative1(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        if (root == null) return root;
        s.push(root);

        while (!s.isEmpty()) {
            //visit
            TreeNode curr = s.pop();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) s.push(curr.left);
            if (curr.right != null) s.push(curr.right);
        }

        return root;
    }

    // it can happen that the due to the recursive calls the memomory
    // stack overflows but simulating it iteratively using a stack can keep a check on that
    // true recursion simulation using stack in trees
    public TreeNode preorderIterative(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode ret = root;
        //PRE-ORDER TRAVERSAL REPLICATION
        if (root == null) return null;
        s.push(root);
        // recursively also the program ends when the recusion stack is fully unwinded
        // in other words it is fully empty
        while (!s.isEmpty()) {

            // therefore to simulate that all the nodes should be in the stack
            // and in the same manner as recursion
            // the right subtree is first dealt with and then left subtree
            // as subtree is being dealt SO the identifiers of each subtree
            // has to be in the stack(therefore both subtree root)

            if (root.left != null) s.push(root.left);
            if (root.right != null) s.push(root.right);

            // SELF - WORK
            //pre order work
            // but the nodes are dealt with in a dfs/recursion manner
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root = s.pop(); // root is being updated
        }
        return ret;
    }
}
